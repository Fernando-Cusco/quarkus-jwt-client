package cusco.mejia.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import cusco.mejia.model.ProductoItem;

@ApplicationScoped
public class ProductoService {

    List<ProductoItem> items = new ArrayList<>();

    public ProductoService() {
        items.add(new ProductoItem(1L, "Producto 1", 10));
        items.add(new ProductoItem(2L, "Producto 2", 20));
        items.add(new ProductoItem(3L, "Producto 3", 30));
        items.add(new ProductoItem(4L, "Producto 4", 40));
        items.add(new ProductoItem(5L, "Producto 5", 50));
    }

    public List<ProductoItem> getItems() {
        return items;
    }

    public void addItem(ProductoItem item) {
        items.add(item);
    }

    public void deleteItem(Long id) {
        items.removeIf(item -> item.getId().equals(id));
    }
    
}
