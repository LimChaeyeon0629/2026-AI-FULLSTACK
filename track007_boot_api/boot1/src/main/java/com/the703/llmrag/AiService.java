package com.the703.llmrag;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiService {

  private final RestClient openAiRestClient;

  // 1. 업로드된 pdf 파일에서 원문텍스트 추출 - retrieval 역할수행 / 컨텍스트 증감
  //	사용자가 새 PDF 업로드 extractTextFromPdf(MultipartFile file)
  public String extractTextFromPdf(MultipartFile file) throws IOException {
      try (PDDocument document = Loader.loadPDF(file.getBytes())) {
          PDFTextStripper stripper = new PDFTextStripper();
          return stripper.getText(document); // pdf전체 텍스트추출
      }
  }

  // 2. ai 연동 후 결과 도출
  public String askToGptWithContext(String context, String question) {
	  String systemInstruction = "당신은 업로드된 문서내용을 기반으로 답변하는 전문 비서입니다."; // ##
	  String userPrompt = "--- [문서 내용] ---\n%s\n --- [질문] ---\n%s".formatted(context, question); // ##

	  // 메시지 리스트 필드
      List<Message> messages = List.of(
              new Message("system", systemInstruction),
              new Message("user", userPrompt)
      );
      //////////////////////////////////////////////////////////
      LlmRagRequest requestBody = new LlmRagRequest("gpt-4o-mini", messages); // ##
 
      LlmRagResponse response = openAiRestClient.post() // OpenAI API 호출용 RestClient 객체로 post 요청
              .uri("/chat/completions")
              .body(requestBody)
              .retrieve()
              .body(LlmRagResponse.class); // ##
 
      // 응답테스트 가공
      if (response != null && !response.choices().isEmpty()) {
          return response.choices().get(0).message().getContent();
      }
      
      return "AI 응답을 생성하지 못했습니다.";
  }
  
  // 로컬고정용파일
  //	업로드 안 해서 기본 PDF 사용 extractTextFromPdf(InputStream inputStream)
  public String extractTextFromPdf(InputStream inputStream) throws IOException {
      try (PDDocument document = Loader.loadPDF(inputStream.readAllBytes())) {
          PDFTextStripper stripper = new PDFTextStripper();
          return stripper.getText(document);
      }
  }

}
