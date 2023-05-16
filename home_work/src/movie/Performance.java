package movie;

public class Performance extends Culture {
	String genre;

	Performance(String title, int dirNum, int actNum, String genre) {
		super(title, dirNum, actNum);
		this.genre = genre;
	}


	@Override
	public void getInformation() {
		System.out.println("공연제목 : " + title);
		System.out.println("감독 : " + dirNum);
		System.out.println("배우 : " + actNum);
		System.out.println("영화총점 : " + score);
		System.out.println("영화평점 : " + getGrade());

	}

}
