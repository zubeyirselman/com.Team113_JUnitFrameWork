package day13_ExcelOtomasyonu_Screenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void tets01() throws IOException {

        // 1) 4.hucreye yeni bir cell olusturalim
        // 2) Olusturdugumuz hucreye “Nufus” yazdiralim
        // 3) 2.satir nufus kolonuna 1500000 yazdiralim
        // 4) 10.satir nufus kolonuna 250000 yazdiralim
        // 5) 15.satir nufus kolonuna 54000 yazdiralim
        // 10) Dosyayi kaydedelim


        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/day12_webTables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");

        // 1) 4.hucreye yeni bir cell olusturalim
        // 2) Olusturdugumuz hucreye “Nufus” yazdiralim
        sheet.getRow(0).createCell(4).setCellValue("Nufus");

        // 3) 2.satir nufus kolonuna 1500000 yazdiralim
        sheet.getRow(1).createCell(4).setCellValue("1500000");

        // 4) 10.satir nufus kolonuna 250000 yazdiralim
        sheet.getRow(9).createCell(4).setCellValue("250000");

        // 5) 15.satir nufus kolonuna 54000 yazdiralim
        sheet.getRow(14).createCell(4).setCellValue("54000");

        // 6) Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        fis.close();
        fos.close();
        workbook.close();

    }
}
