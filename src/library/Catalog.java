package library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Catalog implements java.lang.Iterable<CatalogItem>{

    private ArrayList<CatalogItem> catalogItemArrayList;

    public Catalog(){
        this.catalogItemArrayList = new ArrayList<CatalogItem>();
    }

    public void addItem(CatalogItem item) {
        catalogItemArrayList.add(item);
    }

    public void removeItem(CatalogItem item) {
        catalogItemArrayList.remove(item);
    }

    public CatalogItem getItem(String title) {
        for (CatalogItem item: catalogItemArrayList){
            if(item.getTitle().equals(title))
                return item;
        }
        return null;
    }

    public CatalogItem getItem(int index) {
        for (CatalogItem item: catalogItemArrayList){
            String code = item.getCode().substring(1);
            if(Integer.parseInt(code) == index)
                return item;
        }
        return null;
    }

    public int getNumberOfItems() {
        return catalogItemArrayList.size();
    }



    @Override
    public Iterator<CatalogItem> iterator() {
        // TODO Auto-generated method stub
        return this.catalogItemArrayList.iterator();
    }


}

