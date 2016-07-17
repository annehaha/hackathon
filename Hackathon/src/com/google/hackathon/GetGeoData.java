package com.google.hackathon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetGeoData
 */
@WebServlet("/GetGeoData")
public class GetGeoData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetGeoData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		File inputFile = new File("C:\\Users\\zhangtong\\workspace\\Hackathon\\WebContent\\test.csv");
		
		FileInputStream fis = new FileInputStream(inputFile);
		InputStreamReader isr = new InputStreamReader(fis);
	    BufferedReader in = new BufferedReader(isr);
	    
	    String s = in.readLine();
	    System.out.println(s);
	    StringBuilder sb = new StringBuilder("[");
	    String[] data = s.split(",");
	    sb.append("{timestamp:" + data[0] + ",lat:" + data[1] + ",lng:" + data[2] + "}");
	    s = in.readLine();
	    while(s != null){
	    	sb.append(",");
	    	data = s.split(",");
	    	sb.append("{timestamp:" + data[0] + ",lat:" + data[1] + ",lng:" + data[2] + "}");
		    s = in.readLine();
	    }
	    sb.append("]");
	    
	    in.close();
	    
	    PrintWriter out = response.getWriter();
	    System.out.println(sb.toString());
	    out.write(sb.toString());
		/*PrintWriter out = response.getWriter();
	    out.write("[{timestamp:1, lat: 37.772, lng: -122.214},"
	    		+ "{timestamp:5000, lat: 21.291, lng: -157.821},"
	    		+ "{timestamp:10000, lat: -18.142, lng: 178.431}]");*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
