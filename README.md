# ๐ฅ Java+DB ์ํ์๋งค ํ๋ก๊ทธ๋จ
- <b>Language</b> : <img alt="JAVA" src="https://img.shields.io/badge/JAVA-007396?style=flat-square&logo=java&logoColor=white"/>
- <b>Database</b> : <img alt="Oracle" src ="https://img.shields.io/badge/Oracle-%23F00000.svg?style=flat-square&logo=oracle&logoColor=white" />
- <b>Tool</b> : <img alt="Eclipse IDE" src="https://img.shields.io/badge/Eclipse IDE-2C2255?style=flat-square&logo=Eclipse IDE&logoColor=white"/>
- ์๋ฐ ์ฝ์๋ก๋ง ์๋ํ๋ ํ๋ก๊ทธ๋จ์๋๋ค.

<br>

## ๐ ์ ์๊ธฐ๊ฐ ๋ฐ ๊ฐ๋ฐ์ธ์
- ๊ธฐ๊ฐ : 2021.10 ~ 2021.10 (์ฝ 1์ฃผ)
- ์ธ์ : 3๋ช

<br>

## ๐ ์ฃผ์ ๊ธฐ๋ฅ

### ๐ธ ๋ฉ์ธ๋ฉ๋ด
- <b>๋ฉ๋ด ์ ํ</b> : ๋ฉ๋ด๋ง ์ถ๋ ฅํด์ฃผ๋ ๋ฉ์๋๋ฅผ ๋ฐ๋ก ๋ง๋ค์ด ํ์ํ ๋๋ง๋ค ์ถ๋ ฅํจ
- <b>ํ์๊ฐ์ / ๋ก๊ทธ์ธ / ๋ก๊ทธ์์ / ์ ๋ณด์์ </b> : ํ์ ๊ด๋ จ ๊ธฐ๋ฅ, ๋ก๊ทธ์ธ ์ดํ ์๋งค ๊ธฐ๋ฅ ์ฌ์ฉ๊ฐ๋ฅ
- <b>์์์ค์ธ ์ํ์ ๋ณด</b> : ๋ก๊ทธ์ธํ์ง ์์๋ ๋ฐ์ดํฐ๋ฒ ์ด์ค์์ ์ํ์ ๋ณด๋ฅผ ๋ถ๋ฌ์ ์ํ์ ๋ณด ํ์ธ ๊ฐ๋ฅ

<img src="img/main.PNG" width="200" height="390" >

<details>
<summary>์ฝ๋๋ณด๊ธฐ</summary>
<div markdown="1">

```java
///Main_Controller.java
check = false;
System.out.print("์์ด๋ ์๋ ฅ >>");
id = sc.next();
System.out.print("๋น๋ฐ๋ฒํธ ์๋ ฅ >>");
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
		System.out.println("์์ด๋ ํน์ ๋น๋ฐ๋ฒํธ๋ฅผ ๋ค์ ํ์ธํด์ฃผ์ธ์.");
	}

public static void Menu() {
	System.out.println("1.ํ์๊ฐ์");
	System.out.println("2.ํํด");
	System.out.println("3.๋ก๊ทธ์ธ");
	System.out.println("4.ํ์์ ๋ณด๋ณ๊ฒฝ");
	System.out.println("5.์์์ค์ธ ์ํ์ ๋ณด");
	System.out.println("0.์ข๋ฃ");

}
```
				
</div>
</details>

#### ๐ธ ์๋ธ๋ฉ๋ด
- <b>์ํ ์๋งค</b> : DB์ ์ ์ฅ๋ ์์์ค์ธ ์ํ์ ๋ณด๋ฅผ ๊ฐ์ ธ์ค๊ณ  ์๋งค๋ ์๋ฆฌ๋ผ๋ฉด | * |๋ก ํ์๋ฉ๋๋ค.
- ์๋งค ์ ํ์์ ๋์ด๊ฐ ๊ด๋ ๊ฐ๋ฅ ์ฐ๋ น๋ณด๋ค ์ด๋ฆฌ๋ค๋ฉด ์๋งค๋์ง ์์ต๋๋ค.

<img src="img/sub.PNG" width="220" height="380" >

	
<details>
<summary>์ฝ๋๋ณด๊ธฐ</summary>
<div markdown="1">
	
```java

//๋์ด์ ํ
for (int i = 0; i < dtos2.size(); i++) {
	if (dtos2.get(i).getTitle() == title)
		movie_age_limit = dtos2.get(i).getAge_Limit(); // movie_age_limit์ ์ ํ๋์ด๋ฅผ ์ ์ฅ
}

for (int i = 0; i < dtos.size(); i++) {
	if (dtos.get(i).getID().equals(loginID))
		member_age = dtos.get(i).getBorn(); // member_age์ ํ์ ๋์ด๋ฅผ ์ ์ฅ
}

if (movie_age_limit > member_age) {
	System.out.print("ํด๋น ์ํ์ ์์๋ฑ๊ธ์ " + movie_age_limit + "์ธ ์ด์ ๊ด๋๊ฐ๋ฅ์ด๋ฉฐ\n");
	System.out.print("ํ์๋์ ๋์ด๋ " + member_age + "์ธ ์ด๋ฏ๋ก ์๋งคํ์ค ์ ์์ต๋๋ค.\n");
	break;
}
```

```java
//์ํ ์๋งค
System.out.print("์ํ์๋ ์๊ฐ์ ์๋ ฅํด์ฃผ์ธ์ >>");
String timechoice = sc.next();
System.out.println();
System.out.println("|     S C R E E N     |");
System.out.println();

for (int i = 0; i < dtos2.size(); i++) {
	if (dtos2.get(i).getTitle().equals(title)) {
	if (dtos2.get(i).getMovie_Time().contains(timechoice)) {
		timeSelect = dtos2.get(i).getMovie_Time(); // timeSelect์ ์ํ์๊ฐ์ ๋ณด ์ ์ฅ
		if (dtos2.get(i).getReserved() != 0) { // ์ด๋ฏธ ์์ฝ๋ผ์๋ค๋ฉด ์ซ์๋์  *๋ก ํ์
			System.out.print(" |*|");
		} else if (dtos2.get(i).getReserved() == 0) {
			int seat = dtos2.get(i).getSeat(); // db์ข์์ ๋ณด๋ฅผ seat์ ์ ์ฅ
			if (seat == 6) { // ์ฝ์์ฐฝ ์ค๋ฐ๊ฟ
				System.out.println();
			}
			if (seat != 0) { // ๋๋ฏธ์ํธํ๋ณ
				System.out.print(" |" + seat + "|");
			}
		}
	}
	System.out.println("\n");
	System.out.print("'*'ํ์๊ฐ ์๋ ์๋ฆฌ๋ฒํธ๋ฅผ ์๋ ฅํด์ฃผ์ธ์ >>");
	timeSelect = timeSelect.substring(11, 19);
	seatchoice = sc.nextInt();
	dtos2 = service2.UpdateMovieReserved(title, timeSelect, seatchoice, loginID);

	break;
```
				 
</div>
</details>


#### ๐ธ ์ํ์๋งค์กฐํ

```java
public static void subMenu() {
	System.out.println();
	System.out.println("1.ํ์์ ๋ณด์กฐํ");
	System.out.println("2.์ํ์๋งค");
	System.out.println("3.์ํ์๋งค์ ๋ณด");
	System.out.println("0.๋ก๊ทธ์์");
	}
```

- ์๋ธ๋ฉ๋ด์์ ํ๋ฒ ๋ ๋น๋ฐ๋ฒํธ ํ์ธ ํ ์ผ์นํ๋ค๋ฉด ์๋งค์ ๋ณด์กฐํ๊ฐ ๊ฐ๋ฅํฉ๋๋ค.
- ์๋งค์ ๋ณด๊ฐ ์๋ค๋ฉด ์๋ธ๋ฉ๋ด๋ก ๋ค์ ๋์๊ฐ๋๋ค.

```java
// ์ํ์๋งค์ ๋ณด
dtos2 = service2.getAllMovie();
check = false;
System.out.print("๋น๋ฐ๋ฒํธ ์๋ ฅ >>");
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
		System.out.printf("%s๋์ ์๋งค์ ๋ณด", loginID);
		System.out.println();

		for (int i = 0; i < dtos2.size(); i++) {
			if (dtos2.get(i).getId().equals(loginID)) {
                		System.out.println("์ํ ์ ๋ชฉ : " + dtos2.get(i).getTitle());
				System.out.println("์ํ ์๊ฐ : " + dtos2.get(i).getMovie_Time().substring(11, 19));
				System.out.println("์ข์ ๋ฒํธ : " + dtos2.get(i).getSeat());
			}else {
				System.out.printf("%s๋์ ์๋งค์ ๋ณด๊ฐ ์์ต๋๋ค. ๋ค์ ํ์ธํด์ฃผ์ธ์", loginID);
				break;
				}
			}
		}
```

# ๐ ๊ฐ์ฌํฉ๋๋ค.
