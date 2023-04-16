package rest.api.model;

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

public class Cliente {

	private static WebTarget criar() {
		Client cliente = ClientBuilder.newClient();
		WebTarget web = cliente.target("http://localhost/");
		return web;
	}

	private static void criar(Produto produto) {
		WebTarget web = criar().path("/criar");
		Response resposta = web.request().post(Entity.json(produto));
		System.out.println(resposta.getStatus() + " " + resposta.readEntity(String.class));
		resposta.close();
	}
	
	private static void deletar(Long id) {
		WebTarget web = criar().path("/produto/{id}");
		Response resposta = web.queryParam("id",id).request().delete();
		System.out.println(resposta.getStatus() + " " + resposta.readEntity(String.class));
		resposta.close();
	}
	
	public static void listar(){
		WebTarget web = criar().path("/produto/{id}");
		Response resposta = web.request().get();
		System.out.println(resposta.getStatus());
		List<Produto> produtos = resposta.readEntity(new GenericType<List<Produto>>(){});
		for (Produto produto : produtos) {
			System.out.println(produto.getValor()+" "+produto.getQuantidade());
		}
		resposta.close();
	}
	
	private static void alterar(Alterar params) {
		WebTarget web = criar().path("/produto/{id}");
		Response resposta = web.request().put(Entity.json(params));
		System.out.println(resposta.getStatus() + " " + resposta.readEntity(String.class));
		resposta.close();
	}
	
	public static void main(String[] args) {
		criar(new Titulo());
		criar(new Titulo(3,"batata",20));
		criar(new Titulo(4,"batata2",120));
		listar();
		deletar(5L);
		deletar(4L);
		listar();
		listar();
	}

}
