package movie;

public abstract class Culture {
//	- 제목, 참여감독 수, 참여배우 수, 관객수, 총점을 필드로 가진다.
//	- 제목, 참여감독 수, 참여배우 수는 생성자를 이용하여 값을 초기화한다.
//	- 메소드는 다음과 같이 정의한다.
//	(1) public void setTotalScore(int score) : 관객수와 총점을 누적시키는 기능
//	(2) public String getGrade() : 평점을 구하는 기능
//	(3) public abstract void getInformation() : 정보를 출력하는 추상메소드

	String title; //영화제목
	int dirNum; //감독수
	int actNum; //배우수
	int audNum; //관객수
	int score; //총점
	int grade; //평점


	Culture(String title, int dirNum, int actNum){
		this.title = title;
		this.dirNum = dirNum;
		this.actNum = actNum;
		
	}

	public void setTotalScore(int score, int audNum) {
			this.score = this.score + score;
			this.audNum = this.audNum + audNum;
	}
	
	public String getGrade() {
		String grade = "";
		for(int i=0; i<this.grade; i++) { //this 다시보기
			grade = grade + "☆";
		}
		return grade;
	}
	
	public abstract void getInformation();
	
	
	
}
