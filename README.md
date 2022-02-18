# 💡 Java+DB 영화예매 프로그램
- Eclipse를 사용해 진행하였습니다.
- DataBase는 Oracle을 사용해 진행하였습니다.

<br>

# <제작기간 및 개발인원>
- 기간 : 2021.10 ~ 2021.10 (약 1주)
- 인원 : 3명
- 담당 역할 : 회원기능(가입, 탈퇴), 로그인 및 영화 좌석 조회, 예매 기능

<br>

## <주요 기능>

#### *메인메뉴
- 회원가입 및 탈퇴, 로그인 및 상영중인 영화정보를 조회할 수 있습니다.
- 아이디와 패스워드가 일치하면 회원정보변경도 가능합니다.
- 만약 아이디와 패스워드가 일치하지 않는다면 메인메뉴로 되돌아갑니다.
- 로그인 이후 서브메뉴에서 예매,조회,회원정보조회가 가능합니다.

```java
///Main_Controller.java
check = false;
System.out.print("아이디 입력 >>");
id = sc.next();
System.out.print("비밀번호 입력 >>");
pw = sc.next();
dtos = service.getAllMembers();
for (int i = 0; i < dtos.size(); i++) {
	if (dtos.get(i).getID().equals(id)) {
		if (dtos.get(i).getPW().equals(pw)) {
			check = true;
		}
	}
}
	if (check == false) {
		System.out.println("아이디 혹은 비밀번호를 다시 확인해주세요.");
	}

public static void Menu() {
	System.out.println("1.회원가입");
	System.out.println("2.탈퇴");
	System.out.println("3.로그인");
	System.out.println("4.회원정보변경");
	System.out.println("5.상영중인 영화정보");
	System.out.println("0.종료");

}
```

#### * 영화예매
- DB에 저장된 상영중인 영화정보를 가져오고 예매된 자리라면 | * |로 표시됩니다.
- 예매 시 회원의 나이가 관람 가능 연령보다 어리다면 예매되지 않습니다.

```java

//나이제한
for (int i = 0; i < dtos2.size(); i++) {
	if (dtos2.get(i).getTitle() == title)
		movie_age_limit = dtos2.get(i).getAge_Limit(); // movie_age_limit에 제한나이를 저장
}

for (int i = 0; i < dtos.size(); i++) {
	if (dtos.get(i).getID().equals(loginID))
		member_age = dtos.get(i).getBorn(); // member_age에 회원 나이를 저장
}

if (movie_age_limit > member_age) {
	System.out.print("해당 영화의 상영등급은 " + movie_age_limit + "세 이상 관람가능이며\n");
	System.out.print("회원님의 나이는 " + member_age + "세 이므로 예매하실 수 없습니다.\n");
	break;
}
```

```java
//영화 예매
System.out.print("원하시는 시간을 입력해주세요 >>");
String timechoice = sc.next();
System.out.println();
System.out.println("|     S C R E E N     |");
System.out.println();

for (int i = 0; i < dtos2.size(); i++) {
	if (dtos2.get(i).getTitle().equals(title)) {
	if (dtos2.get(i).getMovie_Time().contains(timechoice)) {
		timeSelect = dtos2.get(i).getMovie_Time(); // timeSelect에 영화시간정보 저장
		if (dtos2.get(i).getReserved() != 0) { // 이미 예약돼있다면 숫자대신 *로 표시
			System.out.print(" |*|");
		} else if (dtos2.get(i).getReserved() == 0) {
			int seat = dtos2.get(i).getSeat(); // db좌석정보를 seat에 저장
			if (seat == 6) { // 콘솔창 줄바꿈
				System.out.println();
			}
			if (seat != 0) { // 더미시트판별
				System.out.print(" |" + seat + "|");
			}
		}
	}
	System.out.println("\n");
	System.out.print("'*'표시가 없는 자리번호를 입력해주세요 >>");
	timeSelect = timeSelect.substring(11, 19);
	seatchoice = sc.nextInt();
	dtos2 = service2.UpdateMovieReserved(title, timeSelect, seatchoice, loginID);

	break;
```

#### * 영화예매조회

```java
public static void subMenu() {
	System.out.println();
	System.out.println("1.회원정보조회");
	System.out.println("2.영화예매");
	System.out.println("3.영화예매정보");
	System.out.println("0.로그아웃");
	}
```

- 서브메뉴에서 한번 더 비밀번호 확인 후 일치하다면 예매정보조회가 가능합니다.
- 예매정보가 없다면 서브메뉴로 다시 돌아갑니다.

```java
// 영화예매정보
dtos2 = service2.getAllMovie();
check = false;
System.out.print("비밀번호 입력 >>");
sc.next();
for (int i = 0; i < dtos.size(); i++) {
	if (dtos.get(i).getID().equals(loginID)) {
	if (dtos.get(i).getPW().equals(pw)) {
		check = true;
		}
	}
}
	if (check == true) {
		System.out.println();
		System.out.printf("%s님의 예매정보", loginID);
		System.out.println();

		for (int i = 0; i < dtos2.size(); i++) {
			if (dtos2.get(i).getId().equals(loginID)) {
                		System.out.println("영화 제목 : " + dtos2.get(i).getTitle());
				System.out.println("영화 시간 : " + dtos2.get(i).getMovie_Time().substring(11, 19));
				System.out.println("좌석 번호 : " + dtos2.get(i).getSeat());
			}else {
				System.out.printf("%s님의 예매정보가 없습니다. 다시 확인해주세요", loginID);
				break;
				}
			}
		}
```

# 😘 감사합니다.
