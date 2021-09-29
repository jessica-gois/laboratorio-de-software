package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.EntidadeDominio;
import model.domain.Result;

public interface IViewHelper {
	public EntidadeDominio getEntidade (HttpServletRequest request, HttpServletResponse response); 
	void setView (Result resultado,HttpServletRequest request, HttpServletResponse response) throws IOException;
}