package library;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.zip.DataFormatException;

public class LibrarySystem {
    private final static String DELIM = "_";
    private final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private final static String Book_PREFIX = "Book";
    private final static String Recording_PREFIX = "Recording";

    private Catalog catalog;

    private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter stdOut = new PrintWriter(System.out, true);
    private static PrintWriter stdErr = new PrintWriter(System.err, true);


    public void loadCatalogFormFile(String fileName) throws IOException, FileNotFoundException, DataFormatException, ParseException{
        catalog = new Catalog();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        while (line!=null){
            CatalogItem eitem = readItem(line);
            catalog.addItem(eitem);
            line = reader.readLine();
        }
        reader.close();

        //return list;
    }

    private CatalogItem readItem(String line) throws DataFormatException, ParseException{
        StringTokenizer tokenizer = new StringTokenizer(line, DELIM);
        if(tokenizer.countTokens()!=6){
            System.out.println("data formate error");
        }else{
            try{
                String prefix = tokenizer.nextToken();
                if(prefix.equalsIgnoreCase(Book_PREFIX)){
                    Book book = new Book(tokenizer.nextToken(), tokenizer.nextToken(), format.parse(tokenizer.nextToken()),
                            tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()));
                    return (CatalogItem)book;
                }else if(prefix.equalsIgnoreCase(Recording_PREFIX)){
                    Recording recording = new Recording(tokenizer.nextToken(), tokenizer.nextToken(), format.parse(tokenizer.nextToken()),
                            tokenizer.nextToken(), tokenizer.nextToken());
                    return (CatalogItem)recording;
                }
                }catch(NumberFormatException nfe){
                throw new DataFormatException(line);
            }

        }
        return null;
    }

    public void saveCatalogToFile(String fileName) throws IOException{
        FileWriter writer = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(writer);

        Iterator it = catalog.iterator();
        while(it.hasNext()){
            CatalogItem item = (CatalogItem) it.next();
            bw.write(item.toString() + "\n");
        }
        bw.close();
        writer.close();
    }

    public void displayCatalogItems() {
        Iterator it = catalog.iterator();
        while(it.hasNext()){
            CatalogItem item = (CatalogItem) it.next();
            stdOut.println(item.toString());
        }
    }

    private int getChoice() throws IOException{
        int input;
        do{
            try{
                stdErr.println();
                stdErr.print("0）quit\n" +"1) display all catalogItems\n"
                        + "2) display detail info of one item by title\n"
                        + "3) add a new Book/Record\n"
                        + "4) delete a Book/Record by title\n"
                        + "5) delete a Book/Record by index\n"
                        + "6) save all catalogItem to file with the file name user input\n");
                stdErr.flush();
                input = Integer.parseInt(stdIn.readLine());
                stdErr.println();
                if(input >= 0 && input<=6){
                    break;
                }else {
                    stdErr.println("Invalid choice: "+input);
                }
            }catch (NumberFormatException nfe){
                stdErr.println(nfe);
            }
        }while (true);
        return input;
    }

    private void run() throws IOException, DataFormatException, ParseException{
        int choice = getChoice();
        while(choice!=0){
            if(choice == 1){
                displayCatalogItems();
            }else if(choice == 2){
                String line = stdIn.readLine();
                stdOut.println(catalog.getItem(line).toString());

            }else if(choice == 3){
                String line = stdIn.readLine();
                CatalogItem item = readItem(line);
                catalog.addItem(item);
            }else if(choice == 4){
                String line = stdIn.readLine();
                CatalogItem item = catalog.getItem(line);
                catalog.removeItem(item);
            }else if(choice == 5){
                String line = stdIn.readLine();
                CatalogItem item = catalog.getItem(Integer.parseInt(line));
                catalog.removeItem(item);
            }else if(choice == 6){
                String line = stdIn.readLine();
                saveCatalogToFile(line);
            }
            choice = getChoice();
        }
    }

    public static void main(String[] args) throws IOException, DataFormatException, ParseException{
        // TODO Auto-generated method stub
        LibrarySystem app = new LibrarySystem();
        app.loadCatalogFormFile("F:\\catalog.dat");
        app.run();
    }

}
