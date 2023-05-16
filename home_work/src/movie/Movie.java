package movie;

public class Movie extends Culture {
	String genre;

	Movie(String title, int dirNum, int actNum, String genre) {
		super(title, dirNum, actNum);
		this.genre = genre;
	}


	@Override
	public void getInformation() {
		System.out.println("영화제목 : " + title);
		System.out.println("감독 : " + dirNum);
		System.out.println("배우 : " + actNum);
		System.out.println("영화 총점 : " + score);
		System.out.println("영화평점 : " + getGrade());

	}

}
