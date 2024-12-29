package com.example.loginsecurity.controller;

import java.util.Arrays;
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

    @GetMapping("/backreports")
    public String backreports() {
        return "reportes";
    }

    @GetMapping("/contacts")
    public String getContactPage(Model model) {
        List<Contact> contacts = Arrays.asList(
                new Contact("Rafael Ordoñez",
                        "Full Stack Developer with over 10 years of experience in the industry.",
                        "969095541",
                        "/photo/kev3.jpg"),
                new Contact("Khev Hide",
                        "Cybersecurity Specialist, expert in enterprise data protection.",
                        "941691210",
                        "/photo/kev.jpg"),
                new Contact("Estrada Jerson",
                        "Backend Developer passionate about designing scalable architectures.",
                        "925306641",
                        "/photo/kev1.jpg"),
                new Contact("Gerson Tejada",
                        "QA Engineer specialized in automated and functional testing.",
                        "932594496",
                        "/photo/kev2.jpg"));

        if (contacts.isEmpty()) {
            model.addAttribute("error", "No se encontraron contactos disponibles en este momento.");
            return "error-page";
        }

        model.addAttribute("contacts", contacts);
        model.addAttribute("modalTitle", "!Welcome!");
        model.addAttribute("modalMessage", "Your ultimate source for detailed inspection data.");
        model.addAttribute("footerText", "© 2024 Inspection Report. All rights reserved.");
        model.addAttribute("logoText", "Inspection");
        model.addAttribute("homeLink", "Inicio");
        model.addAttribute("reportLink", "Reporte");
        model.addAttribute("contactLink", "Contacto");
        model.addAttribute("welcomeTitle", "Welcome a Inspection Report");
        model.addAttribute("welcomeSubtitle", "Your ultimate source for detailed inspection data.");

        return "contacts";
    }

    @GetMapping("/backproducts")
    public String backproducts() {
        return "productos";
    }

    @GetMapping("/reportes")
    public String productosBajoStock(Model model) {
        int stockMinimo = 30;
        List<Productos> productosBajoStock = proservices.getProductsWithLowStock(stockMinimo);
        model.addAttribute("productos", productosBajoStock);
        return "reportes";
    }

    @GetMapping("/powerbi")
    public String getInspectionReport(Model model) {
        model.addAttribute("logoText", "Inspection");
        model.addAttribute("homeLink", "Home");
        model.addAttribute("reportLink", "Report");
        model.addAttribute("contactLink", "Contact");

        model.addAttribute("modalTitle", "Welcome!");
        model.addAttribute("modalMessage", "We're glad to have you here. Explore our inspection reports and data.");

        model.addAttribute("welcomeTitle", "Welcome to the Inspection Report");
        model.addAttribute("welcomeSubtitle", "Your comprehensive source for detailed inspection data.");

        model.addAttribute("footerText", "© 2024 Inspection Report. All rights reserved.");

        model.addAttribute("iframeUrl",
                "https://app.powerbi.com/view?r=eyJrIjoiMDNhMWY1MmQtZDFmYS00ZDU1LTgzNmQtNjJmNjIzY2RkNjc4IiwidCI6IjEwYWVmMTg5LTA1ZGItNGY2Zi05NTdmLTI3MGY5N2JmNTAzYiIsImMiOjZ9");

        return "powerbi";
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

    public static class Contact {
        private String name;
        private String description;
        private String whatsappNumber;
        private String imagePath;

        public Contact(String name, String description, String whatsappNumber, String imagePath) {
            this.name = name;
            this.description = description;
            this.whatsappNumber = whatsappNumber;
            this.imagePath = imagePath;
        }

        // Getters y setters
        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getWhatsappNumber() {
            return whatsappNumber;
        }

        public String getImagePath() {
            return imagePath;
        }
    }
}
