package excel.firstwork;

import excel.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FirstTestWork {
         private static final Logger logger = LogManager.getLogger(FirstTestWork.class.getName());

       public void processTitles(){
           String path = "src\\main\\resources\\data.xlsx";
           FileInputStream fis = Util.getStream(path);
           XSSFWorkbook workbook = Util.readXLSfile(fis);
           /*List<ItemData> data  = getDataFromFile(workbook);
           List<String> titles = getTitles(data);*/
           List<ItemData4s> data4s  = get4sDataFromFile(workbook);
           List<String> titles4s = getTitles4S(data4s);



           closeResources(workbook, fis);
       }

    private List<ItemData4s> get4sDataFromFile(XSSFWorkbook workbook) {
        List<ItemData4s> result = new ArrayList<>();
        XSSFSheet sheet = workbook.getSheetAt(1);
        Iterator<Row> rowIt = sheet.iterator();
        boolean skipped = false;
        while(rowIt.hasNext()) {
            Row row = rowIt.next();
            if (!skipped){
                skipped = true;
                continue;
            }
            ItemData4s data = getItemData4sFromRow(row);
            logger.debug("got data " + data);
            result.add(data);
        }

        return result;
    }

    private ItemData4s getItemData4sFromRow(Row row) {
        ItemData4s data = new ItemData4s();
        String partNo = row.getCell(0).getStringCellValue();
        String make = row.getCell(4).getStringCellValue();
        String model = row.getCell(5).getStringCellValue();
        Cell cell = row.getCell(6);
        String submodel = "";
        if (cell!=null){
            try {
                submodel=cell.getStringCellValue();
            }
            catch (IllegalStateException e){
                submodel = cell.getNumericCellValue()+"";
            }
        }
        String drive = "";
        cell = row.getCell(7);
        if (cell!=null){
            drive=cell.getStringCellValue();
        }
        cell = row.getCell(8);
        String kitRequired = "";
        if (cell!=null){
            kitRequired = cell.getStringCellValue();
        }
        String year = row.getCell(9).getStringCellValue();
        String frontLift = row.getCell(10).getStringCellValue();
        String rearLift = row.getCell(11).getStringCellValue();
        String position = row.getCell(12).getStringCellValue();
        String rearSeries = row.getCell(13).getStringCellValue();
        String frontSeries = row.getCell(14).getStringCellValue();
        Double frontPart = row.getCell(15).getNumericCellValue();
        Double rearPart = row.getCell(16).getNumericCellValue();
        Boolean boolField = row.getCell(17).getBooleanCellValue();

        /*cell = row.getCell(11);
        Double part = 0d;
        try {
            part = cell.getNumericCellValue();
        }
        catch (IllegalStateException e){
            logger.debug(cell.getStringCellValue());
            part = Double.parseDouble(cell.getStringCellValue());
        }
        String lift = row.getCell(12).getStringCellValue();
        String position = row.getCell(13).getStringCellValue();*/

        data.setPartNo(partNo);
        data.setMake(make);
        data.setModel(model);
        data.setSubmodel(submodel);
        data.setDrive(drive);
        data.setKitRequired(kitRequired);
        data.setYear(year);
        data.setFrontLift(frontLift);
        data.setRearLift(rearLift);
        data.setPosition(position);
        data.setRearSeries(rearSeries);
        data.setFrontSeries(frontSeries);
        data.setFrontPart(frontPart);
        data.setRearPart(rearPart);
        data.setBoolField(boolField);


        return data;

    }

    private List<String> getTitles4S(List<ItemData4s> dataList) {
        List<String> result = new ArrayList<>();
        dataList.forEach(data->{
            StringBuilder titleBuilder = new StringBuilder();
            titleBuilder.append("Pro Comp ");
            String frontSeries = data.getFrontSeries();
            String rearSeries = data.getRearSeries();
            titleBuilder.append(frontSeries);
            if (!frontSeries.equals(rearSeries)){
                titleBuilder.append("/");
                titleBuilder.append(rearSeries);
            }
            //"Pro Comp [Series] [Position] [Lift] shocks for [Make] [Model] [Submodel] [4WD/2WD] [Year]"
            titleBuilder.append(" ");
            titleBuilder.append("Front & Rear");
            titleBuilder.append(" ");
            //lift
            String frontLift = data.getFrontLift();
            String rearLift = data.getRearLift();
            if (!frontLift.equals("0\"")){
                if (frontLift.equals(rearLift)){
                    titleBuilder.append(frontLift);
                    titleBuilder.append(" ");
                }
                else {
                    titleBuilder.append("Front ");
                    titleBuilder.append(frontLift);
                }
            }
            if (!rearLift.equals("0\"")){
                if (!rearLift.equals(frontLift)){
                    if (!frontLift.equals("0\"")){
                        titleBuilder.append("/");
                    }
                    titleBuilder.append("Rear ");
                    titleBuilder.append(rearLift);
                }
            }
            String currentTitle = titleBuilder.toString();
            if (!currentTitle.endsWith(" ")){
                titleBuilder.append(" ");
            }
            titleBuilder.append("shocks for ");
            titleBuilder.append(data.getMake());
            titleBuilder.append(" ");
            titleBuilder.append(data.getModel());
            titleBuilder.append(" ");

            String submodel = data.getSubmodel();
            if (submodel.length()>1){
                titleBuilder.append(submodel);
                titleBuilder.append(" ");
            }


            //1) Составить заголовки по формату: "Pro Comp [Series] [Position] [Lift] shocks for [Make] [Model] [Submodel] [4WD/2WD] [Year]"
            //drive
            String drive = data.getDrive();
            if (drive!=null&&drive.length()>0&&!drive.equals("2WD/4WD")){
                titleBuilder.append(drive);
                titleBuilder.append(" ");
            }
            titleBuilder.append(data.getYear());

            String title = titleBuilder.toString();
            System.out.println(title);
            result.add(title);
        });


        return result;
    }

    private List<String> getTitles(List<ItemData> dataList) {
            List<String> result = new ArrayList<>();
            dataList.forEach(data->{
                StringBuilder titleBuilder = new StringBuilder();
                titleBuilder.append("Pro Comp ");
                titleBuilder.append(data.getSeries());
                titleBuilder.append(" ");
                titleBuilder.append(data.getPosition());
                titleBuilder.append(" ");
                //lift
                String lift = data.getLift();
                if (!lift.equals("0\"")){
                    titleBuilder.append(lift);
                    titleBuilder.append(" ");
                }
                titleBuilder.append("shocks for ");
                titleBuilder.append(data.getMake());
                titleBuilder.append(" ");
                titleBuilder.append(data.getModel());
                titleBuilder.append(" ");

                String submodel = data.getSubmodel();
                if (submodel.length()>1){
                    titleBuilder.append(submodel);
                    titleBuilder.append(" ");
                }


                //1) Составить заголовки по формату: "Pro Comp [Series] [Position] [Lift] shocks for [Make] [Model] [Submodel] [4WD/2WD] [Year]"
                //drive
                String drive = data.getDrive();
                if (drive!=null&&drive.length()>0&&!drive.equals("2WD/4WD")){
                    titleBuilder.append(drive);
                    titleBuilder.append(" ");
                }
                titleBuilder.append(data.getYear());

                String title = titleBuilder.toString();
                //logger.debug(title);
                System.out.println(title);
                result.add(title);
            });


           return result;
    }

    private void closeResources(XSSFWorkbook workbook, FileInputStream fis) {
        try {
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<ItemData> getDataFromFile(XSSFWorkbook workbook){
           List<ItemData> result = new ArrayList<>();
           XSSFSheet sheet = workbook.getSheetAt(0);
           Iterator<Row> rowIt = sheet.iterator();
           boolean skipped = false;
           while(rowIt.hasNext()) {
               Row row = rowIt.next();
               if (!skipped){
                   skipped = true;
                   continue;
               }
               ItemData data = getItemDataFromRow(row);
               logger.debug("got data " + data);
               result.add(data);

           }

           return result;
       }

    private ItemData getItemDataFromRow(Row row) {
             ItemData data = new ItemData();
               String partNo = row.getCell(0).getStringCellValue();
               String make = row.getCell(4).getStringCellValue();
               String model = row.getCell(5).getStringCellValue();
               Cell cell = row.getCell(6);
               String submodel = "";
               if (cell!=null){
                try {
                    submodel=cell.getStringCellValue();
                }
                catch (IllegalStateException e){
                    submodel = cell.getNumericCellValue()+"";
                }
                }
               String drive = "";
                cell = row.getCell(7);
               if (cell!=null){
                   drive=cell.getStringCellValue();
               }
               cell = row.getCell(8);
               String kitRequired = "";
               if (cell!=null){
                   kitRequired = cell.getStringCellValue();
               }
               String year = row.getCell(9).getStringCellValue();
               String series = row.getCell(10).getStringCellValue();
               cell = row.getCell(11);
               Double part = 0d;
               try {
                   part = cell.getNumericCellValue();
               }
               catch (IllegalStateException e){
                   logger.debug(cell.getStringCellValue());
                   part = Double.parseDouble(cell.getStringCellValue());
               }
               String lift = row.getCell(12).getStringCellValue();
               String position = row.getCell(13).getStringCellValue();

               data.setPartNo(partNo);
               data.setMake(make);
               data.setModel(model);
               data.setSubmodel(submodel);
               data.setDrive(drive);
               data.setKitRequired(kitRequired);
               data.setYear(year);
               data.setSeries(series);
               data.setPart(part);
               data.setLift(lift);
               data.setPosition(position);

               return data;
    }

}
