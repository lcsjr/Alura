package br.com.diversos.code.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class EnvioEmail {

	private static HSSFWorkbook workbook;

	public static void main(String[] args) {
		
		try {

			System.out.println("Iniciando Execução...");
			
			DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

			int dia = 18;
			int mes = 02;
			int ano = 2019;
			int hora = 13;
			int minuto= 35;

			LocalDateTime proxExecucao = LocalDateTime.of(ano, mes, dia, hora, minuto);
			String prox = proxExecucao.format(formatDateTime);
			System.out.println("Proxima Execução: " + prox);	

			LocalDateTime dt = LocalDateTime.now();
            System.out.println(dt.format(formatDateTime) + " " + dt.compareTo(proxExecucao) );


            if ( dt.compareTo(proxExecucao) == 1) {
//			if (temAlteracao()) {
				
            	proxExecucao = proxExecucao.plus(1, ChronoUnit.DAYS);
            	
            	String[] u = null;
				Zip.main(u);

				LocalDateTime dateTime = LocalDateTime.now();
				String destinatarios = "luiz.santos@thomsonreuters.com";// , welles.aquino@thomsonreuters.com,
																		// rodrigo.cassis@thomsonreuters.com";
				String assuntoEmail = "ONESOURCE ECF - Comparação Tabelas Dinâmicas ";
				StringBuilder corpoEmail = new StringBuilder();
				corpoEmail.append("Prezado(a)," + System.lineSeparator() + System.lineSeparator());
				corpoEmail.append("O resultado da análise na comparação das Tabelas Dinâmicas encontrou uma nova atualização que requer sua avaliação.");
				corpoEmail.append(System.lineSeparator() + "Segue em anexo arquivo completo com as planilhas.");
				corpoEmail.append(System.lineSeparator() + System.lineSeparator() + "Favor avaliar e dar andamento no processo de atualização.");
				corpoEmail.append(System.lineSeparator() + System.lineSeparator() + dateTime.format(formatDateTime));

				Email email = new Email();
				email.enviaEmailComAnexos(destinatarios, assuntoEmail, corpoEmail.toString());

				System.out.println("==============================================================================================================");
				System.out.println("Executado em : " + dateTime.format(formatDateTime));
				System.out.println("Terminou");
				System.out.println("==============================================================================================================");
			}
			// sleep(60*1000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static boolean abreExcel(int pos, String planilha) throws IOException {

		FileInputStream file = new FileInputStream(new File("./target/" + planilha));
		workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);

		if (sheet != null) {
			Iterator<Row> itRow = sheet.iterator();
			while (itRow.hasNext()) {
				Row row = itRow.next();
				if (row.getRowNum() > 1) {
					if (row.getCell(pos).getStringCellValue().equals("ADD"))
						return true;
					if (row.getCell(pos).getStringCellValue().equals("UPDATE"))
						return true;
					if (row.getCell(pos).getStringCellValue().equals("REMOVE"))
						return true;
				}
			}
		}

		workbook.close();

		return false;
	}

	private static boolean temAlteracao() throws IOException {

		List<String> listPlanilhas = new ArrayList<>();
		File files = new File("./target");
		File afiles[] = files.listFiles();

		int i = 0;
		for (int j = afiles.length; i < j; i++) {
			File arquivos = afiles[i];

			Boolean extensao = arquivos.getName().toLowerCase().endsWith(".xls");

			if (extensao && !arquivos.isHidden()) {
				listPlanilhas.add(arquivos.getName());
			}
		}

		boolean retorno = false;
		for (String plan : listPlanilhas) {

			if (!retorno && plan.toLowerCase().contains("planoreferencial"))
				retorno = abreExcel(11, plan);
			if (!retorno && plan.toLowerCase().contains("tabdinamica"))
				retorno = abreExcel(12, plan);
			if (!retorno && plan.toLowerCase().contains("acessorias"))
				retorno = abreExcel(7, plan);
		}
		return retorno;
	}

}
