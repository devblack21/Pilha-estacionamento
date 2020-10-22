package controller;

import java.util.Scanner;

import model.Carro;

public class Estacionamento {

	private final Scanner scan;
	private final Pilha<String> p1;
	private final Pilha<String> p2;

	public Estacionamento(int max) {
		this.scan = new Scanner(System.in);
		this.p1 = new Pilha<>(max);
		this.p2 = new Pilha<>(max);

	}

	public static void main(String[] args) {
		Estacionamento e = new Estacionamento(10);
		while (e.mover()) {
		}
	}

	private boolean mover() {
		System.out.println("Informe a movimentação do carro: ");
		char mov = scan.nextLine().charAt(0);
		switch (mov) {
		case 'C':
			adicionar();
			return true;
		case 'P':
			retirar();
			return true;
		case 'X':
			return false;
		default:
			System.out.println("Desculpe, não entendi isso.");
			return true;
		}
	}

	private void adicionar() {
		if (p1.estaCheia()) {
			System.out.println("Estacionamento cheio!");
		} else {
			System.out.println("Por favor, informe a placa: ");
			String placa = scan.nextLine();
			Carro carro = new Carro();
			carro.setPlaca(placa);
			p1.inserir(carro);
			System.out.println(placa + " foi inserido.");
		}
	}

	private void retirar() {
		Pilha<Carro> p2 = new Pilha<>(p1.tamanho());
		System.out.println("Informe a placa do carro a ser retirado: ");

		Carro car = new Carro();
		String placa = scan.nextLine();
		car.setPlaca(placa);

		if (p1.contains(car)) {

			int posicao = p1.indexOfObject(car);

			if (posicao > p1.tamanho()) {
				System.out.println(
						"Não podemos retirar o carro " + placa + " pois o último é o " + (p1.tamanho()) + ".");
				return;
			}
			while (p1.tamanho() > posicao) {
				Carro rem = p1.remover();
				rem.addManobra();
				p2.inserir(rem);

			}
			Carro carroRemovido = p2.remover();
			while (!p2.estaVazia()) {
				p1.inserir(p2.remover());
			}

			System.out.println("O carro removido foi o " + carroRemovido.getPlaca() + " com "
					+ carroRemovido.getManobras() + " Manobras");
		}
	}

	@Override
	public String toString() {
		return p1.toString();
	}

	public boolean estaCheia() {
		return p1.estaCheia();
	}
}