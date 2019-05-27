package de.fhws.Aufgabe19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Exam {
	private ArrayList<Question> questions = new ArrayList<>();

	private String readHeaderFromFile() {
		String result = "";
		
		return result;
	}
	
	public static void main(String[] args) {
		Exam exam = new Exam();
		try {
			exam.readQuestions().toTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	Inner readQuestions() throws IOException {
		FileReader fr = new FileReader("questions.csv");
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		
		while((line = br.readLine()) != null) {
			questions.add(Question.toQuestion(line));
		}
		
		br.close();
		fr.close();
		
		return new Inner(this);
	}
	
	class Inner {
		private Exam e;
		
		private Inner(Exam e) {
			this.e = e;
		}
		
		Exam toTest() throws IOException{
			FileWriter fw = new FileWriter("test.tex");
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(readHeaderFromFile());
			bw.newLine();
				
			for (Question question: questions) {
				bw.write("\\textbf{" + question.text + "}\\\\");
				bw.newLine();
			}
			
			bw.write("\\end{document}");
			bw.close();
			fw.close();
			
			return e;
		}
	}
}
