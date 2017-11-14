package com.cafe24.sns.utility;

import com.cafe24.sns.model.Interest;
import com.cafe24.sns.model.Person;
import com.cafe24.sns.model.PersonInterest;
import com.cafe24.sns.service.InterestService;
import com.cafe24.sns.service.PersonInterestService;
import com.cafe24.sns.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Component
public class RandomPersonMaker {
	@Autowired
	private InterestService interestService;
	@Autowired
	private PersonInterestService personInterestService;
	@Autowired
	private PersonService personService;

	public InterestService getInterestService() {
		return interestService;
	}

	public void makeModel(int personCount, int interestCount) {
		makePersonInterest(personCount);
		makeFriendship();
	}

	private void makeFriendship() {

	}

	protected void makeInterest(int interestCount) {
		Queue<String> q = new LinkedList<>();
		q.addAll(RESTAURANT_NAME_LIST);

		if (interestCount > q.size())
			interestCount = q.size();

		for (int i = 0; i < interestCount; i++) {
			String name = q.poll();
			Interest interest = new Interest(null, Interest.Category.RESTAURANT,name);
			interestService.add(interest);
		}
	}

	protected void makePerson(int personCount) {
		for (int i = 0; i < personCount; i++) {
			int age = (int) (Math.random() * 40) + 10;
			Person person = new Person(makeRandomPersonName(), age, makeRandomImageUrl());

			personService.add(person);
		}
	}

	protected void makePersonInterest(int personCount) {
		System.out.println("size : " + personService.get(2L).getPersonInterestList().size());
	}

	protected Interest getRandomInterest() {
		long interestCount = interestService.getCount();
		long randomIndex = (long) (Math.random() * interestCount);
		return interestService.get(randomIndex);
	}

	private String makeRandomImageUrl() {
		int index = (int) Math.random() * 412;
		String url = "";
		if (index > 42) {
			String indexStr = "";
			if (index - 42 < 10) {
				indexStr = "00" + (index - 42);
			} else if (index - 42 < 100) {
				indexStr = "0" + (index - 42);
			} else {
				indexStr = String.valueOf(index - 42);
			}
			url = "f" + indexStr + ".png";
		} else {
			url = index + ".jpg";
		}
		return url;
	}

	private String makeRandomRestaurantName() {
		int randomIndex = (int) (Math.random() * RESTAURANT_NAME_LIST.size());
		return RESTAURANT_NAME_LIST.get(randomIndex);
	}

	private String makeRandomPersonName() {
		int lastNameIndex = (int) (Math.random() * LAST_NAME_LIST.size());
		int firstNameLeftIndex = (int) (Math.random() * FIRST_NAME_LEFT_LIST.size());
		int firstNameRightIndex = (int) (Math.random() * FIRST_NAME_RIGHT_LIST.size());
		return LAST_NAME_LIST.get(lastNameIndex) + FIRST_NAME_LEFT_LIST.get(firstNameLeftIndex) + FIRST_NAME_RIGHT_LIST
				.get(firstNameRightIndex);
	}

	private final List<String> RESTAURANT_NAME_LIST = Arrays
			.asList("신전 떡볶이", "홍콩반점", "안동찜닭", "도스마스", "맥도날드", "롯데리아", "JUICY", "할매 순대국", "김밥천국", "도스타코스", "니뽕내뽕",
					"도미노 피자", "미스터 피자", "피자헛", "굽네 치킨", "온누리 쭈꾸미", "엉터리 생고기", "삼목 등심", "안동장", "라이스&포테이토", "동해해물칼국수",
					"상도곱창", "장독대", "스시후", "오시오 떡볶이", "죠스 떡볶이", "아딸", "하노이의 별", "준호네 돈가스", "곱창의 전설", "홍천 닭갈비", "모모치 카레",
					"치즈를 사랑한 찜닭", "성민양꼬치", "고씨네", "채홍", "북경반점", "치폴레옹", "철판목장", "쭈노치킨", "기꾸참치", "더돼지", "싸움의 고수",
					"샤브 일번가");

	private final List<String> LAST_NAME_LIST = Arrays
			.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안", "송", "류", "전",
					"홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주", "우",
					"구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염",
					"양", "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기",
					"반", "왕", "금", "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");

	private final List<String> FIRST_NAME_LEFT_LIST = Arrays
			.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다", "단", "달", "담",
					"대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박", "백",
					"범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙",
					"순", "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우",
					"원", "월", "위", "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정",
					"제", "조", "종", "주", "준", "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "태", "택", "판",
					"하", "한", "해", "혁", "현", "형", "혜", "호", "홍", "화", "환", "회", "효", "휘", "희", "운", "모", "배", "부", "림",
					"봉", "혼", "황", "량", "린", "을", "비", "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱",
					"휴", "언", "령", "섬", "들", "견", "추", "걸", "삼", "열", "웅", "분", "변", "양", "출", "타", "흥", "곤", "식", "란",
					"더", "손", "술", "훔", "반", "빈", "실", "직", "흠", "흔", "악", "람", "권", "복", "심", "헌", "엽", "학", "개", "평",
					"늘", "늬", "얀", "향", "울", "련");
	private final List<String> FIRST_NAME_RIGHT_LIST = Arrays
			.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다", "단", "달", "담",
					"대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "박", "백", "범",
					"별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
					"숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원",
					"월", "위", "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제",
					"조", "종", "주", "준", "중", "지", "진", "찬", "창", "천", "철", "초", "치", "태", "택", "판", "하", "한", "해", "혁",
					"현", "형", "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황",
					"량", "린", "을", "비", "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령",
					"섬", "들", "견", "추", "걸", "삼", "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "식", "란", "더", "손",
					"술", "훔", "반", "빈", "실", "직", "흠", "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "랑", "향",
					"울", "련");
}
