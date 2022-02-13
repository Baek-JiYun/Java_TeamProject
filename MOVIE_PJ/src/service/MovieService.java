package service;

import java.util.ArrayList;

import dao.MovieDAO;
import dto.MovieVO;

public class MovieService {
	private MovieDAO dao;
	
	public MovieService(){
		dao = new MovieDAO();
	}

	public ArrayList<MovieVO> getAllMovie() {		
		return dao.getAllMovie();
	}

	public ArrayList<MovieVO> UpdateMovieReserved(String title, String timeSelect, int seatchoice,String loginID) {		
		return dao.UpdateMovieReserved(title,timeSelect,seatchoice,loginID);
	}
}
