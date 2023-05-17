package day12_webTables_excelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {

        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/day12_webTables_excelOtomasyon/ulkeler.xlsx";

        // Bilgisayarimizda olan bir dosyaya erisebilmek icin FileInputStream Class'indan obje olusturalim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // Projemize ekledigimiz POI kutuphanelerini kullanarak
        // Class'imizin icinde istenen excel'in bir kopyasini olusturalim
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(3);

        System.out.println(cell);

        // 5.index'deki satirin, 1.index'indeki datanin "Luanda" oldugunu test edin
        row = sheet.getRow(5);
        cell = row.getCell(1);

        String expectedData = "Luanda";
        Assert.assertEquals(expectedData,cell.toString());

        // cell objesinin data turu Cell
        // Java'da farkli data turlerindeki variable'lari equals ile KULLANAMAYIZ

        // 12.satir, 2.sutundaki bilginin "Baku" oldugunu test edin
        String actualData = sheet.getRow(11).getCell(1).toString();
        expectedData ="Baku";

        Assert.assertEquals(expectedData,actualData);

    }
}
