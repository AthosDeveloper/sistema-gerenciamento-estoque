package com.catalisa.sistemaEstoque.service;

import com.catalisa.sistemaEstoque.model.DTOS.ProductDTO;
import com.catalisa.sistemaEstoque.model.Product;
import com.catalisa.sistemaEstoque.repository.ProductRepository;
import com.catalisa.sistemaEstoque.service.exceptions.DataIntegrityViolationException;
import com.catalisa.sistemaEstoque.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProductRepository repository;
    @Override
    public List<Product> findAll(){
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
return  obj.orElseThrow(() -> new ObjectNotFoundException("produto não encontrado"));

    }
    @Override
public Product create(ProductDTO obj){

        findByName(obj);
   return repository.save(mapper.map(obj, Product.class));
    }
@Override
public Product update(ProductDTO obj) {
findByName(obj);
return  repository.save(mapper.map(obj, Product.class));
}

    @Override
    public void delete(Long id) {
findById(id);
repository.deleteById(id);
    }
    private  void findByName(ProductDTO obj){
        Optional<Product> product = repository.findByName(obj.getName());
        if (product.isPresent() && !product.get().getId().equals(obj.getId())){
            throw new DataIntegrityViolationException("nome do produto já cadastrado no sistema");
        }
}
}
