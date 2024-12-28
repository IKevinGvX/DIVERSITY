package com.example.loginsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.loginsecurity.model.Productos;
import com.example.loginsecurity.services.Categoriaservices;
import com.example.loginsecurity.services.ProductoServices;

@Controller
public class ProductoController {
    @Autowired
    private ProductoServices proservices;
    @Autowired
    private Categoriaservices cateservices;

    @PostMapping("/updateproducts")
    public String updateproducts(@ModelAttribute("productos") Productos pro) {
        proservices.updateproducts(pro);
        return "redirect:/productos";
    }

    @GetMapping("/formregisterproducts")
    public String formregistrarproducts(Model model) {
        Productos emp = new Productos();
        model.addAttribute("productos", emp);
        model.addAttribute("categorias", cateservices.getallcategoria());
        return "registrarproductos";
    }

    @GetMapping("/reportes")
    public String productosBajoStock(Model model) {
        int stockMinimo = 30;
        List<Productos> productosBajoStock = proservices.getProductsWithLowStock(stockMinimo);
        model.addAttribute("productos", productosBajoStock);
        return "reportes";
    }

    @GetMapping("/bajo-stock")
    public String productosConBajoStock(Model model) {
        List<Productos> productos = proservices.getProductsWithLowStock(30);
        model.addAttribute("productos", productos);
        return "bajo-stock";
    }

    @PostMapping("/saveproductsexists")
    public String saveproductsexists(@ModelAttribute("productos") Productos emp) {
        proservices.saveproducts(emp);
        return "redirect:/productos";
    }

    @GetMapping("/openupdate/{id}")
    public String getproductsbyi(@PathVariable(value = "id") long id, Model model) {
        Productos produ = proservices.getproductsbyid(id);
        model.addAttribute("productos", produ); // Producto a actualizar
        model.addAttribute("categorias", cateservices.getallcategoria()); // Lista de categorías
        return "actualizarproductos"; // Nombre del archivo HTML
    }

    @GetMapping("/deleteproducts/{id}")
    public String deleteproducts(@PathVariable(value = "id") long id) {
        this.proservices.deleteproducts(id);
        return "redirect:/productos";
    }
}
