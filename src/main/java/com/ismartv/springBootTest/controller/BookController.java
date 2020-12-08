package com.ismartv.springBootTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ismartv.springBootTest.config.NacosConfig;
import com.ismartv.springBootTest.dao.api.BookDaoInterface;
import com.ismartv.springBootTest.entity.Book;
import com.ismartv.springBootTest.properties.BookProperties;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/")
@Log4j2
public class BookController {

	
	private BookDaoInterface bookDaoInterface;
	private BookProperties bookProperties;
	private NacosConfig nacosConfig;
	
	@Autowired
	public BookController(BookDaoInterface bookDaoInterface, BookProperties bookProperties){
		this.bookDaoInterface = bookDaoInterface;
		this.bookProperties = bookProperties;
	}
	
	@SentinelResource("book")
	@RequestMapping(value = "/book/{reader}", method = RequestMethod.GET)
	public String bookList(Model model, @PathVariable("reader") String reader){
//		log.info("bookList price{}", bookProperties.getPrice());
		log.info("nacos config: user:{} password:{}", nacosConfig.getUsername(), nacosConfig.getPassword());
		List<Book> bookList = bookDaoInterface.findByReader(reader);
		model.addAttribute("bookList", bookList);
		return "bookList";
	}
	
	
	@RequestMapping(value = "/book/{reader}", method = RequestMethod.POST)
	public String add(Book book, @PathVariable("reader") String reader){
		book.setReader(reader);
		bookDaoInterface.save(book);
		return "redirect:/book/{reader}";
	}
}
