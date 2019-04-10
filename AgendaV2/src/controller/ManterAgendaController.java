package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Agenda;
import model.service.AgendaService;



@WebServlet("/ManterAgenda")
public class ManterAgendaController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aNome = request.getParameter("nome");
		String aEndereco = request.getParameter("endereco");
		String aTelefone = request.getParameter("telefone");
		String aEmail = request.getParameter("email");
		
		
		//instanciar o javabean
		Agenda agenda = new Agenda();
		agenda.setNome(aNome);
		agenda.setEndereco(aEndereco);
		agenda.setTel(Integer.parseInt(aTelefone));
		agenda.setEmail(aEmail);
		
		
		//instanciar o service
		AgendaService ag = new AgendaService();
		ag.criar(agenda);
		agenda = ag.carregar(agenda.getId_cliente());
		
		request.setAttribute("agenda", agenda);
		RequestDispatcher view = request.getRequestDispatcher("Agenda.jsp");
		view.forward(request, response);
		
	}
}
