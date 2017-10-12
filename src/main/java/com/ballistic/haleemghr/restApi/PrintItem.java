package com.ballistic.haleemghr.restApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.print.*;
import javax.print.attribute.*;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.List;

/**
 * Created by Nabeel on 10/10/2017.
 */
@RestController
@RequestMapping("/print")
public class PrintItem implements IPrintItem {

    private PrintService printServices[];
    private DocFlavor flavor;
    private PrintService service;
    private PrintRequestAttributeSet pras;

    public PrintService[] getPrintServices() { return printServices; }

    public DocFlavor getFlavor() { return flavor; }

    public PrintService getService() { return service; }

    public PrintRequestAttributeSet getPras() { return pras; }


    private PrintItem() {

        this.flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        this.pras =  new HashPrintRequestAttributeSet();
        this.printServices = PrintServiceLookup.lookupPrintServices(this.getFlavor(), getPras());

    }

    @RequestMapping(value = PRINT_LIST, method= RequestMethod.GET)
    @Override
    public List<String> getPrinterList() {

        List<String> printerList = new ArrayList<String>();
        for (PrintService printerService : getPrintServices()) {
            printerList.add(printerService.getName());
        }

        return printerList;
    }

    @RequestMapping(value = Path, method = RequestMethod.POST)
    @Override
    public ResponseEntity<?> getPrintResponse(String printName, String bill) {

        try {

            this.service = findPrintService(printName);
            DocPrintJob job = this.getService().createPrintJob();

            try {

                byte[] bytes = bill.getBytes("CP437");
                // cut that paper!
                byte[] cutP = new byte[] { 0x1d, 'V', 1 };

                job.print(this.getxyz(bytes), null);
                job.print(this.getxyz(cutP),null);

            } catch (PrintException e) {
                // TODO Auto-generated catch block
                return new ResponseEntity<String>("Place Check the Connection of Your Printer" + printName, HttpStatus.NOT_FOUND);
            } catch (UnsupportedEncodingException e) {
                return new ResponseEntity<String>("Problem Converting the String into Bytes" + bill, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>("Check the Printer" + printName + "Bill is " + bill, HttpStatus.OK);

        }catch (NullPointerException e) {
            return  new ResponseEntity<String>("Some think Wrong", HttpStatus.BAD_REQUEST);
        }
    }

    private Doc getxyz(byte[] bytes){
        Doc doc = new SimpleDoc(bytes, this.getFlavor(), null);
        return doc;
    }

    private PrintService findPrintService(String printerName) {

        for (PrintService service : this.getPrintServices()) {
            if (service.getName().equalsIgnoreCase(printerName)) {
                return service;
            }
        }
        return null;
    }

}