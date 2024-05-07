package category.product.serviceClasses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import category.product.entityClasses.Category;
import category.product.exception.CategoryNotFoundException;
import category.product.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> retrieveAllCategory(int page)
    {
        PageRequest pageRequest=  PageRequest.ofSize(page);
        Page<Category> categoryPage= categoryRepository.findAll(pageRequest);
        List<Category> categories= categoryPage.getContent();
        return categories;
    }

    public Optional<Category> retrieveOneCategory(int id)
    {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty())
            throw new CategoryNotFoundException("id :"+id);
        return  category;

    }

    public Category saveCategory(Category category)
    {
        Category saveCategory=categoryRepository.save(category);
        return saveCategory;  
    }

    public Category updateCategory(int id ,Category category)
    {
        Optional<Category> findCategory=categoryRepository.findById(id);
        if(findCategory.isEmpty())
            throw  new CategoryNotFoundException("id : "+id);
        Category updateCategory =categoryRepository.save(category);
        return updateCategory;
    }

    public void deleteCategory(int id)
    {
        categoryRepository.deleteById(id);
    }
}
