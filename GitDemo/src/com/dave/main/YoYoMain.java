package com.dave.main;

import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class YoYoMain {
	
	public static void main(String args[]) throws IOException, COSVisitorException{
		// Create a new empty document
		PDDocument document = new PDDocument();

		// Create a new blank page and add it to the document
		PDPage page = new PDPage();
		document.addPage( page );
		
		// Create a new font object selecting one of the PDF base fonts
		PDFont font = PDType1Font.HELVETICA_BOLD;
		
		// Start a new content stream which will "hold" the to be created content
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		
		contentStream.beginText();
		contentStream.setFont( font, 12 );
		contentStream.moveTextPositionByAmount( 100, 600 );
		contentStream.drawString( "First Last" );
		contentStream.endText();
		contentStream.beginText();
		
		font = PDType1Font.COURIER_BOLD_OBLIQUE;
		
		contentStream.setFont( font, 16 );
		contentStream.moveTextPositionByAmount( 100, 350 );
		contentStream.drawString( "What's My Name Jimmy?" );
		contentStream.endText();
		
		// Make sure that the content stream is closed:
		contentStream.close();

		// Save the newly created document
		document.save("BlankDave.pdf");

		// finally make sure that the document is properly
		// closed.
		document.close();

	}

}
