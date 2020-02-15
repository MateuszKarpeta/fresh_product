
package pl.karpeta.mateusz.fresh_product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.karpeta.mateusz.fresh_product.model.Product;
import pl.karpeta.mateusz.fresh_product.services.ProductService;


@RestController
@RequestMapping(ProductControllerFront.BASE_URL)
public class ProductControllerFront {

    public static final String BASE_URL = "/products";
    private final ProductService productService;

    @Autowired
    public ProductControllerFront(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView getAllProducts() {
        ModelAndView mav = new ModelAndView("products");
        mav.addObject("products", productService.findAllProducts());
        return mav;
    }

    @GetMapping("/delete/{id}")
    ModelAndView deleteProduct(@PathVariable Long Id) throws IllegalAccessException {
        productService.deleteById(Id);
        return new ModelAndView("redirect" + BASE_URL);
    }

    @GetMapping
    public ModelAndView getProductAdd() {
        ModelAndView mav = new ModelAndView("/add");
        mav.addObject("products", new Product());
        return mav;
    }

    @PostMapping
    ModelAndView addProduct(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return new ModelAndView("redirect:" + BASE_URL);
    }
}



