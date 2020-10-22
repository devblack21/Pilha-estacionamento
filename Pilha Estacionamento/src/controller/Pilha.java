package controller;


import java.util.ArrayList;
import java.util.List;
import model.Carro;

public class Pilha<T> {
    private final int max;
    private final List<Carro> elementos;
    private int manobras = 0;

    public Pilha(int max) {
        this.max = max;
        this.elementos = new ArrayList<>(max);
    }

    public boolean estaCheia() {
        return max == elementos.size();
    }
    
    public void addManobra() {
    	this.manobras += 1;
    }
    
    public int getManobras() {
		return manobras;
	}

    public boolean contains(Carro car) {
		return this.elementos.contains(car);
	}
	
	public Integer indexOfObject(Carro car) {
		Integer index = null;
		if(contains(car)) {
			
			index = elementos.indexOf(car);
			
		}
		
		return index;
	}
	
	public Carro getObject(int index) {
		
		return this.elementos.get(index);
	}
    
    public boolean estaVazia() {
        return elementos.isEmpty();
    }

    public boolean inserir(Carro elem) {
        if (this.estaCheia()) return false;
        elementos.add(elem);
        return true;
    }

    public Carro remover() {
        return this.estaVazia() ? null : elementos.remove(elementos.size() - 1);
    }

    @Override
    public String toString() {
        return elementos.toString();
    }

	public int tamanho() {
	
		return elementos.size();
	}
}