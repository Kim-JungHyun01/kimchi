package com.kr.kimchi.service;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.kr.kimchi.vo.ContractsVO;
import com.kr.kimchi.vo.ItemVO;
import com.kr.kimchi.vo.MaterialVO;
import com.kr.kimchi.vo.ObtainVO;
import com.kr.kimchi.vo.PartnerVO;
import com.kr.kimchi.vo.UserVO;

@Service
public class PdfService {

	@Inject
	private ItemService itemservice;
	@Inject
	private PartnerService partservice;
	@Inject
	private ContractsService conservice;
	@Inject
	private ObtainService obtainservice;
	@Inject
	private MaterialService maservice;
	@Inject
	private UserService userservice;

	//계약서
	public int createContract(int contracts_no, String code_name) {
//		사용할 데이터
		ContractsVO con = conservice.contractsSelect(contracts_no);
		ItemVO item = itemservice.itemSelect(con.getItem_no());
		PartnerVO part = partservice.partnerSelect(con.getPartner_taxid());

		int result = -1;
		Document document = new Document(PageSize.A4, 20, 20, 20, 20);
		String filename = code_name + ".PDF";//파일이름_pdf로 꼭 지정
		String filePath = "C:/Users/A9/Desktop/pdf/" + filename;//파일저장위치
//		String filePath = "src/main/webapp/resources/pdf/" + filename; // 파일 저장 위치
		File file = new File(filePath);

		try (FileOutputStream fos = new FileOutputStream(file)) {
			PdfWriter writer = PdfWriter.getInstance(document, fos);//사용하기는 않지만 필요
			document.open();

			BaseFont baseFont = BaseFont.createFont("HYGoThic-Medium", "UniKS-UCS2-H", BaseFont.NOT_EMBEDDED);
			Font titleFont = new Font(baseFont, 20, Font.BOLD);
			Font contentFont = new Font(baseFont, 10);

			Map<Integer, String> food = contractFood(part, con);
			for (Integer key : food.keySet()) {
				String pathMater = food.get(key);
				Paragraph graph = new Paragraph(pathMater, key == 1 ? titleFont : contentFont);
				if (key == 1 || key == 30) {
					graph.setAlignment(Paragraph.ALIGN_CENTER);
				} else if (key == 4) {
//					표 생성
					PdfPTable table = new PdfPTable(8);
					table.setWidthPercentage(100);
					table.setWidths(new int[] { 30, 30, 130, 50, 25, 50, 80, 80 });//간격 조절
					String[] titleCate = { "계약\n번호", "품목\n코드", "품명", "품목\n단가(원)", "계약\n수량", "계약\n금액(원)", "납기일", "비고" };
					for (String title : titleCate) {
						PdfPCell titleCell = new PdfPCell(new Paragraph(title, contentFont));
						titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
						table.addCell(titleCell);
					}
//					3.데이터추가
					List<Object> tmp = new ArrayList<>();
	                tmp.add(con.getContracts_no());
	                tmp.add(item.getItem_no());
	                tmp.add(item.getItem_name());
	                tmp.add(item.getItem_price());
	                tmp.add(con.getContracts_quantity());
	                tmp.add(con.getContracts_price());
	                tmp.add(con.getContracts_deliveryDate());

	                for (Object it : tmp) {
	                    String itemString = (it instanceof Integer) ? String.valueOf(it) : (String) it;
	                    PdfPCell content = new PdfPCell(new Paragraph(itemString, contentFont));
	                    content.setHorizontalAlignment(Element.ALIGN_CENTER);
	                    table.addCell(content);
	                }

	                // 빈 셀 추가_꼭!!
	                if (tmp.size() < 8) {
	                    for (int i = tmp.size(); i < 8; i++) {
	                        table.addCell(new PdfPCell(new Paragraph("", contentFont))); // 빈 셀 추가
	                    }
	                }

	                document.add(table);
				} else if (key == 13 || key == 18 || key == 21) {
					graph.setIndentationLeft(30);
				}

				document.add(graph);
				document.add(Chunk.NEWLINE);
			}

			result = 1; // 파일 생성 완료
			document.close();//파일 닫기_꼭(중간에 닫아버리면 오류)
		} catch (Exception e) {
			result = 0; // 파일 생성 실패
			e.printStackTrace();
		}
		return result; // 결과 반환
	}//end

//계약서 내용
	private static Map<Integer, String> contractFood(PartnerVO part, ContractsVO con) {
		Map<Integer, String> Food = new HashMap<Integer, String>();

		Food.put(1, "식자재 공급 계약서\r\n");// title

		Food.put(2, part.getPartner_companyname() + " (이하 \"갑\"이라 한다)와 " + "삼김 신조유 "
				+ "(이하 \"을\"이라 한다)는(은) 필요한 삭자재 공급과 관련하여 다음과 같이 계약을 체결한다.\r\n");// intro

		Food.put(3, "제 1조 [발주내역]");

		Food.put(4, null);// 표 넣기_4

		Food.put(5, "단, 상거내역을 기본으로 하고 제품의 품종, 수량, 납기는 \"갑\", \"을\"상호 합의하에 변경할 수 있다.");

		Food.put(6, "제 2조 [목적]\r\n"
				+ " 본 계약은 \"갑\", \"을\"간 식자재 공급 거래와 관련한 제반사항을 규정하고 상호신회를 바탕으로 공정한 거래를 유지하며 상호간 이익을 추구함을 목적으로 한다.\r\n");

		Food.put(7, "제 3조 [계약기간]\r\n" + " ① 본 계약의 계약기간은 " + con.getContracts_deliveryDate() + "까지로 한다.\r\n");

		Food.put(8, "제 4조 [식자재 공급]\r\n" + " ① \"을\"은 \"을\"이 취급하는 식자재를 \"갑\"에게 공급한다.\r\n"
				+ " ② \"을\"은 \"갑\" 또는 \"갑\"이 지정한 자의 발주에 따라 식자재를 공급하기로 한다.\r\n"
				+ " ③ \"갑\"이 발주하는 품목 중 품절된 품목은 \"갑\"과 을의 합의하에 타 품목으로 대체공급할 수 있다.\r\n"
				+ " ④ \"을\"은 \"갑\"이 발주한 품목을 \"갑\"이 지정한 시간과 장소(\"갑\"의 검수장소)에 납품하는 것을 원칙으로 하고 \"갑\"의 요청 또는 \"갑\"과 \"을\"이 합의하는 경우 분할 공급하거나 시간 및 장소를 변경할 수 있다.\r\n");

		Food.put(9, "제 5조 [검수]\r\n"
				+ " ① \"갑\" 또는 \"갑\"이 지정한 자는 \"을\"로부터 식자재를 인도받는 즉시 \"을\"의 입회하에 \"갑\"이 발주시 제시한 식품규격 및 검사명세서에 의거 검수를 실시한다. 단, 쌍방이 합의하는 경우 \"을\"은 검수에 입회하지 아니할 수 있다.\r\n"
				+ " ② 검수시 품질불량, 수량부족, 규격상이, 파손 등 하자가 있을 경우에는 \"갑\"은 인도 당일 \"을\"에게 이의를 제기하여야 하며, \"을\"은 즉시 교체 및 보충하여야 한다. 다만, 즉시 발견할 수 없는 하자가 있는 경우에는 인수 후 그 다음 날까지 이의를 제기할 수 있다.\r\n");

		Food.put(10, "제 6조 [납품]\r\n"
				+ " ① \"갑\"은 \"을\"에게 품목의 종류, 수량, 주문일, 공급기일 및 공급장소 등을 명시한 발주서에 의해 전산 또는 FAX로 발주한다.\r\n"
				+ " ② \"을\"은 \"갑\"의 발주내용에 따라 식자재를 공급한다.\r\n"
				+ " ③ \"갑\"이 \"을\"에게 발주할 수 있는 한도(이하 \"여신한도\"라고 한다)는 \"갑\"의 매출액 및 그 증감액, 대금지급 여부, 담보가치, 신용도 등을 감안하여 정하며, \"을\"은 안정적인 거래를 위하여 이를 조정할 수 있다.\r\n");

		Food.put(11, "제 7조 [공급가격]\r\n"
				+ " 식자재의 가격은 \"갑\"과 \"을\" 상호 합의한 견적주기에 따라 \"을\"이 제시한 견적가를 \"갑\"이 검토한 후 \"을\"과 합의하여 결정한다.\r\n");

		Food.put(12, "제 8조 [대금지급]\r\n" + " ① \"을\"은 월마감 후 익월 초에 전월 식자재 대금에 대한 세금계산서를 \"갑\"에게 발행한다.\r\n"
				+ " ② 대금지급 조건은 (2)호로 한다.");

		Food.put(13,
				"1. \"갑\"은 \"을\"에게 월마감 후 0일까지 전항의 세금계산서상 금액을 \"을\"이 지정한 계좌로 현금지급한다.\r\n"
						+ "	2. \"갑\"은 \"올\"에게 매 발주시마다 식자재 공급물량의 대금을 확인하여 발주 전 당해 금액을 \"올\"이 지정한 계좌로 현금 입금한다.\r\n"
						+ "	3. 기타 :\r\n");

		Food.put(14,
				" ③ \"갑\"이 변제하거나 \"을\"이 상계함으로써 변제충당을 하려는 경우에 \"갑\"의 채무 전액을 소멸시키기에 부족한 경우에는, \"을\"의 모든 채권의 안전하고 확실한 보전을 위하여 상당하다고 인정되는 순서와 방법으로 \"을\"이 따로 정하는 바에 의하여 변제나 상계에 충당할 채무를 지정하기로 하며, 담보있는 채무와 담보없는 채무가 있을 때에는 변제기 도래 여부를 불문하고 담보없는 채무의 변제에 충당하기로 한다.\r\n"
						+ " ④ \"갑\"이 대금의 지급을 지연하는 경우에는 그 지연일로부터 완제일까지 지연금 총액의 연 10%의 비율에 의한 지연손해금을 감안하여 지급하여야 한다.\r\n");

		Food.put(15, "제 9조 [담보]\r\n"
				+ " ① \"갑\"은 본 계약과 관련된 채무이행을 담보하기 위하여 부동산 근저당 또는 은행, 보증보험사의 지급보증 등 \"을\"이 인정하는 담보를 제공한다.\r\n"
				+ " ② \"갑\"의 연대보증인은 본 계약상의 각 조항을 모두 승인하고 본 계약상 \"갑\"이 부담하는 일체의 채무 및 의무를 \"갑\"과 연대하여 이행할 책임을 부담한다.\r\n");

		Food.put(16, "제 10조 [채권잔액 확인]\r\n"
				+ " \"갑\"과 \"을\"은 양 당사자간 인정하는 채권잔액의 불일치 등을 예방하고자 상대방에 대하여 채권잔액 확인을 요청할 수 있으며, 요청받은 상대방 당사자는 이에 응하기로 한다.\r\n");

		Food.put(17,
				"제 11조 [계약의 해지]\r\n" + " ① \"갑\", \"을\"중 일방에게 다음 각호의 어느 하나에 해당하는 사유가 발생한 때에는 상대방 당사자는 계약을 해지할 수 있다.");

		Food.put(18, "1. 본 계약상의 의무를 위반하여 본 계약의 목적달성이 불가능한 경우\r\n"
				+ "	2. 회생, 파산, 청산, 해산 및 그와 유사한 절차의 신청이 있거나 개시된 경우\r\n" + "	3. 부도 또는 지급정지처분을 받은 경우\r\n"
				+ "	4. 제3자에 의하여 압류, 가압류, 가처분 또는 강제집행을 받아 계약이행이 곤란하다고 인정될 때\r\n"
				+ "	5. 공급일자 내에 \"을\"이 고의로 납품을 거부하여 납품을 완료하지 못할 경우\r\n" + "	6. 특별한 사유없이 \"갑\"이 물품대금의 결제를 지연하는 경우\r\n"
				+ "	7. 기타 본 계약상 조항을 위반하여 10일 이상의 기간을 정하여 상대방에 대한 서면통보로써 그 시정을 요구하고 이 기간 내에 시정이 이루어지지 않은 경우\r\n");

		Food.put(19,
				"② 전 항에 의하여 본 계약을 해지할 경우 기한의 이익을 상실하며, 상호간의 채권, 채무액은 정산하고 잔액은 상대방에게 즉시 지급하여야하며, 계약해지로 인한 손해에 대하여 귀책 당사자는 배상하여야 한다.\r\n"
						+ " ③ 전 항의 경우 원상회복의 방법으로 \"을\"로부터 공급받은 식자재의 대금을 결제할 때까지 세금계산서 발행 등에도 불구하고 소유권은 \"을\"에게 유보되어 \"을\"은 소유권유보 목적물을 임의로 회수할 수 있다.\r\n");

		Food.put(20, "제 12조 [위생사고, 클레임 발생시 처리 및 보상]\r\n"
				+ " \"을\"이 \"갑\"에게 공급한 상품중 다음 각호의 사유가 발생한 때에는 \"을\"은 \"갑\"에게 발생된 문제를 처리하기 위한 일체의 비용 및 손해배상액을 \"갑\" 또는 \"갑\"의 고객에게 지불하여야 한다.");

		Food.put(21,
				"1. \"을\"이 \"갑\"에게 공급한 식재료 및 상품을 가지고 \"갑\"이 운영하는 사업장내에서 \"갑\"이 고용한 직원에 의해 조리, 제공한 음식물을 취식 후 위생사고, 클레임이 발생했을 시 해당 사건에 대해 명백한 \"을\"의 귀책사유로 인한 부분에 대해서 \"을\"은 \"갑\" 및 \"갑\"의 고객에게 정신적 물질적 피해를 보상한다.\r\n"
						+ "	2. 위생사고 및 클레임에 대한 귀책사유가 명확히 구분되지 않을 경우에는 발생, 소요비용에 대해 \"을\"이 선처리 후, 최종 비용분담은 \"갑\"과 협의하여 분담한다.\r\n"
						+ "	3. \"을\"의 상품 공급 차질로 인해 발생된 \"갑\"의 실 손실액에 대해 \"을\"은 \"갑\"이 요청한 계좌로 현금 입금한다. 단,\"갑\"의 실 손실액 측정에 대해서는 \"을\"과 협의하여 판단한다.\r\n");

		Food.put(22, "제 13조 [불가항력]\r\n"
				+ " 천재지변, 전쟁, 폭동, 법령제정·개폐, 정부규제 등 불가항력적인 사유로 인하여 \"갑\" 또는 \"을\"에게 손해가 발생하거나 본 계약을 이행할 수 없는 경우 양 당사자는 이와 관련하여 상대방에게 책임을 묻지 아니한다.\r\n");

		Food.put(23, "제 14조 [계약변경]\r\n" + " 본 계약서의 내용은 \"갑\"과 \"을\"의 서면상의 합의에 의하여 변경, 수정할 수 있다.\r\n");

		Food.put(24, "제 15조 [권리, 의무의 양도금지]\r\n"
				+ " \"갑\"과 \"을\"은 상대방의 사전 서면 승인없이 본 계약의 권리, 의무를 제3자에게 양도 또는 담보로 제공할 수 없다.\r\n");

		Food.put(25, "제 16조 [영업비밀유지]\r\n"
				+ " ① \"갑\"과 \"을\"및 그 임직원은 상호간의 거래로 인하여 알게 된 상대방의 영업비밀을 계약기간 동안은 물론 계약종료 후에도 제3자에게 누설하지 아니한다. 다만, 다른 법령에 근거한 정부 또는 공공기관의 요청에 따르거나 법원의 판결에 따른 경우에는 예외로 한다.\r\n"
				+ " ② 어느 일방이 전항의 의무를 위반하여 상대방에게 손해가 발생하였을 경우에는 그 손해를 배상하여야 한다.\r\n");

		Food.put(26, "제 17조 [통보]\r\n" + " \"갑\"과 \"을\"은 사업자등록증에 관한 사항 중 중요 사항이 변경된 경우 상대방에게 통보하여야 한다.\r\n");

		Food.put(27, "제 18조 [해석]\r\n"
				+ " 본 계약에 정하지 아니한 사항 또는 각 조항의 해석상 \"갑\", \"을\"간에 이견이 있는 부분에 관하여는 상호 협의하여 결정하는 것을 원칙으로 하되, 협의가 되지 않는 부분에 관하여는 관련 법령 및 상관례에 따른다.\r\n");

		Food.put(28, "제 19조 [분쟁의 해결]\r\n"
				+ " 본 계약과 관련하여 분쟁이 발생하는 경우 \"갑\"과 \"을\"은 상호 신뢰를 바탕으로 원만히 해결하기로 하되 합의가 이루어지지 아니하여 \"갑\" 또는 \"을\" 사이에 소송의 필요가 생긴 때에는 \"갑\" 또는 \"을\"의 주된 사무소 소재지 관할 법원에 소송을 제기할 수 있다.\r\n");

		Food.put(29, "본 계약을 증명하기 위하여 계약서 2부를 작성 \"갑\"과 \"을\"이 각각 1부씩 보관한다.\r\n");
		
		// 오늘 날짜를 가져옵니다.
		LocalDateTime today = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

		// 원하는 형식으로 변환합니다.
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		String formattedDate = today.format(outputFormatter);
		
		Food.put(30, "\r\n<" + formattedDate + ">\r\n");

		Food.put(31, "\"갑\"\r\n" + "사업자 번호 : 2024-094-105\r\n" + "상        호 : 삼김 신조유 \r\n"
				+ "주        소 : 경기도 수원시 팔달구 덕영대로895번길 9-1 4층\r\n" + "대   표   자 : 조상민\r\n");

		Food.put(32,
				"\"을\"\r\n" + "사업자 번호 : " + part.getPartner_taxid() + "\r\n" + "상        호 : "
						+ part.getPartner_companyname() + " \r\n" + "주        소 : " + part.getPartner_add() + "\r\n"
						+ "대   표   자 : " + part.getPartner_ownername() + "\r\n");

		return Food;
	}// end

	
//	거래명세서 제작
	public int createStatement(int obtain_no, String code_name) {
	    // 사용할 데이터
	    ObtainVO obtain = obtainservice.obtainSelect(obtain_no);
	    MaterialVO ma = maservice.maView(obtain.getMa_id());
	    PartnerVO partner = partservice.partnerSelect(obtain.getPartner_taxid());
	    UserVO user = userservice.userSelect(obtain.getUser_id());

	    // 파일 정보 지정
	    String filename = code_name + ".PDF"; // 파일이름_pdf로 꼭 지정
	    String filePath = "C:/Users/A9/Desktop/pdf/" + filename; // 파일저장위치

	    // 파일 이름 중복 체크 및 수정
	    File file = new File(filePath);
	    int count = 1;
	    while (file.exists()) {
	        String newFilename = code_name + " (" + count + ").PDF"; // 새로운 파일 이름 생성
	        filePath = "C:/Users/A9/Desktop/pdf/" + newFilename; // 새로운 파일 저장 위치
	        file = new File(filePath);
	        count++;
	    }

	    int result = -1;

	    // PDF 생성 및 텍스트 추가
	    Document document = new Document(PageSize.A4, 30, 25, 25, 25); // A4 크기: 210mm x 297mm
	    try {
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
	        document.open();//서류 열기

	        // 이미지 추가
	        String imagePath = "C:/Users/A9/Desktop/거래명세서.jpg"; // 이미지 파일 경로
	        Image img = Image.getInstance(imagePath);

	        // 이미지 크기 조정_사용 가능한 너비: 210mm - 25mm(좌측) - 25mm(우측) = 160mm | 사용 가능한 높이: 297mm - 30mm(상단) - 25mm(하단) = 242mm
	        img.scaleToFit(750, 700);//그림 크기가 작을 경우 키울것

	        // 이미지 위치 설정
	        float x = 25; // 좌측 여백
	        float y = document.getPageSize().getHeight() - 30 - img.getScaledHeight(); // 상단 여백과 이미지 높이를 고려한 Y 좌표
	        img.setAbsolutePosition(x, y); // 이미지 위치 설정
	        document.add(img); // 이미지 추가

	        // PdfContentByte 객체 가져오기
	        PdfContentByte canvas = writer.getDirectContent();
	        BaseFont bf = BaseFont.createFont("HYGoThic-Medium", "UniKS-UCS2-H", BaseFont.NOT_EMBEDDED);
//			BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);// 폰트설정
//			BaseFont bf_kr = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 폰트설정
			canvas.beginText();//글자 추가시작 선언
			canvas.setFontAndSize(bf, 12);//폰트 사이즈
			
			//관리번호_code_name
			float X1 = x + 338; // 이미지 왼쪽 여백(25)+338 = 363
			float Y1 = y + img.getScaledHeight() - 76; // 이미지 높이에 따라 Y 좌표 조정 
			canvas.setTextMatrix(X1, Y1);
			canvas.showText(code_name);//글자추가
	         
	        //담당자
			float Y2 = y + img.getScaledHeight() - 97; // 이미지 높이에 따라 Y 좌표 조정 
			canvas.setTextMatrix(X1, Y2);
			canvas.showText(user.getUser_name());//글자 추가
	         
	         //작성일자
			float Y3 = y + img.getScaledHeight() - 118; // 이미지 높이에 따라 Y 좌표 조정 
			canvas.setTextMatrix(X1, Y3);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//date => string 변환
			canvas.showText(format.format(obtain.getObtain_registrationDate()));//글자 추가
			
	         //공급업체_partner : 협력회사명, 대표자명, 전화번호, fax
			float Y4 = y + img.getScaledHeight() - 165; // 이미지 높이에 따라 Y 좌표 조정 
			
			float X2 = x + 40;
			canvas.setTextMatrix(X2, Y4);
			canvas.showText(partner.getPartner_companyname());//협력회사명
			
			float X3 = x + 190;
			canvas.setTextMatrix(X3, Y4);
			canvas.showText(partner.getPartner_ownername());//대표자명
			
			float X4 = x + 295;
			canvas.setTextMatrix(X4, Y4);
			canvas.showText(partner.getPartner_number());//전화번호
			
			float X5 = x + 435;
			canvas.setTextMatrix(X5, Y4);
			canvas.showText(partner.getPartner_fax());// fax
	         
	         //자재 : 품명, 규격, 수량, 단위, 단가, 금액
			float Y5 = y + img.getScaledHeight() - 225; // 이미지 높이에 따라 Y 좌표 조정 
			
			float X6 = x + 60;
			canvas.setTextMatrix(X6, Y5);
			canvas.showText(ma.getMa_name());//품명
			
			float X7 = x + 143;
			canvas.setTextMatrix(X7, Y5);
			canvas.showText(ma.getMa_specifications());//규격
			
			float X8 = x + 240;
			canvas.setTextMatrix(X8, Y5);
			canvas.showText(Integer.toString(obtain.getObtain_quantity()));//수량
			
			float X9 = x + 275;
			canvas.setTextMatrix(X9, Y5);
			canvas.showText(ma.getMa_unit());//단위
			
			float X10 = x + 305;
			canvas.setTextMatrix(X10, Y5);
			canvas.showText(Integer.toString(ma.getMa_price()));//단가
			
			float X11 = x + 375;
			canvas.setTextMatrix(X11, Y5);
			canvas.showText(Integer.toString(obtain.getObtain_price()));//금액
			
			//합계
			float Y6 = y + img.getScaledHeight() - 600; // 이미지 높이에 따라 Y 좌표 조정 
			canvas.setTextMatrix(X11, Y6);
			canvas.showText(Integer.toString(obtain.getObtain_price()));//합계
			
	        //자재납기일
			float X12 = x + 75;
			float Y7 = y + img.getScaledHeight() - 647; // 이미지 높이에 따라 Y 좌표 조정 
			canvas.setTextMatrix(X12, Y7);
			canvas.showText(obtain.getObtain_deliveryDate());
	         
	         
			canvas.endText();//글자 쓰기 종료
	        document.close();//서류 닫기
	        result = 1; // 파일 생성 성공
	    } catch (Exception e) {
	        result = 0; // 파일 생성 실패
	        e.printStackTrace();
	    }

	    return result;
	} // end

	
	
}// end class
