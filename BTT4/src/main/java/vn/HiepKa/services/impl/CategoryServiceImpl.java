package vn.HiepKa.services.impl;

import java.util.List;

import vn.HiepKa.dao.ICategoryDao;
import vn.HiepKa.dao.impl.CategoryDaoImpl;
import vn.HiepKa.models.CategoryModel;
import vn.HiepKa.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{

	public ICategoryDao cateDao = new CategoryDaoImpl();
	
	@Override
	public List<CategoryModel> findAll() {
		
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {
		
		return cateDao.findById(id);
	}

	@Override
	public void insert(CategoryModel category) {
		cateDao.insert(category);
		
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(category.getCategoryid());
		if(cate != null) {
			cateDao.update(category);
		}
	}

	@Override
	public void delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(id);
		if(cate != null) {
			cateDao.delete(id);
		}
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		// TODO Auto-generated method stub
		return cateDao.findName(keyword);
	}

}
