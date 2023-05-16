package movie;

public class MovieApplication {
	public static void main(String[] args) {
		Movie movie = new Movie("추격자", 7, 5, "액션");
		movie.setTotalScore(50, 12);
		movie.grade = 4;
		movie.getInformation();
		
		Performance pf = new Performance("지킬앤하이드", 9, 10, "뮤지컬");
			pf.setTotalScore(20, 70);
			pf.grade = 5;
			pf.getInformation();
	}
}
