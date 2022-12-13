package br.ifpe.jaboatao.ts.utils;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import java.util.Calendar;
import java.util.Date;

public class DataUtils {
	

	/**
	 * Retorna uma nova data de acordo com a quantidade de dias passada por parametro, a partir de uma data espec�fica.
	 * @param data a ser incrementado/decrementado
	 * @param dias Quantidade de dias que ir� incrementado/decrementado a data
	 * @return Data atualizada
	 */
	public static Date incrementarQntDias(int dias, Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(DAY_OF_MONTH, dias);
		return calendar.getTime();
	}

	
	/**
	 * Retorna uma nova data de acordo com a quantidade de dias passada por parametro.
	 * @param dias Quantidade de dias a ser incrementado/decrementado
	 */
	public static Date incrementarQntDias(int dias) {
		return incrementarQntDias(dias, new Date());
	}	
	/**
	 * Monta e retorna uma instancia da data de acordo com os valores passados por parametro
	 * @param dia
	 * @param mes
	 * @param ano
	 */
	public static Date retornarData(int dia, int mes, int ano){
		Calendar calendar = Calendar.getInstance();
		calendar.set(DAY_OF_MONTH, dia);
		calendar.set(MONTH, mes - 1);
		calendar.set(YEAR, ano);
		return calendar.getTime();
	}

	
	/**
	 * Verifica se duas datas s�o iguais.. Leva em considera��o apenas dia, mes e ano
	 * @param primeiraData
	 * @param segundaData
	 */
	public static boolean boDatasIguais(Date primeiraData, Date segundaData) {
		//Primeira data
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(primeiraData);
		//Segunda data
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(segundaData);
		return (cal1.get(DAY_OF_MONTH) == cal2.get(DAY_OF_MONTH))
				&& (cal1.get(MONTH) == cal2.get(MONTH))
				&& (cal1.get(YEAR) == cal2.get(YEAR));
	}
	
	/**
	 * Verifica se � o dia da semana desejado, de acordo com a data passada.
	 * @param data
	 * @param diaSemana Dia da semana
		 * Domingo 			= 1;
		 * Segunda-feira	= 2;
		 * Ter�a-feira 		= 3;
		 * Quarta-feira		= 4;
		 * Quinta-feira		= 5;
		 * Sexta-feira		= 6;
		 * Sabado			= 7;
	 */
	public static boolean boDiaSemana(Date data, int diaSemana) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		return calendar.get(DAY_OF_WEEK) == diaSemana;
	}
}
