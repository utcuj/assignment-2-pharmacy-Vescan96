package factory_pattern;

import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.List;
import model.Medications;

public class PDF implements File{

	private static final String file = "reports.pdf";

	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    @SuppressWarnings("unused")
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    @SuppressWarnings("unused")
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
	
	@Override
	public void generate(List<Medications> medications) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			addContent(document, medications);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}
	
	private static void addContent(Document document, List<Medications> medications) throws DocumentException {
        Anchor anchor = new Anchor("Medications out of stock", catFont);

        // Second parameter is the number of the chapter
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph subPara = new Paragraph("Table with deleted medications", subFont);
        Section subCatPart = catPart.addSection(subPara);
        
        addEmptyLine(subPara, 2);
        
        // add a table
        createTable(subCatPart, medications);

        // now add all this to the document
        document.add(catPart);
    }

	private static void createTable(Section subCatPart, List<Medications> medications) throws BadElementException {
        PdfPTable table = new PdfPTable(5);

        PdfPCell c1 = new PdfPCell(new Phrase("name"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("ingredients"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("manufacturer"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("quantity"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("price"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        table.setHeaderRows(medications.size());

        for(Medications med : medications)
        { 
        	table.addCell(med.getName());
	        table.addCell(med.getIngredients());
	        table.addCell(med.getManufacturer());
	        table.addCell(""+med.getQuantity());
	        table.addCell(""+med.getPrice());
        }
        
        subCatPart.add(table);

    }

    @SuppressWarnings("unused")
	private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

}
