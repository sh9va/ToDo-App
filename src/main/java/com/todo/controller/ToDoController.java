package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.ToDo;
import com.todo.repository.ToDoRepository;

@RestController
public class ToDoController {

	@Autowired
	private  ToDoRepository toDoRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/todos")
	public List<ToDo> todos(){
		return toDoRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/deletetodo/{id}")
	public boolean  deleteTodo(@PathVariable long id){
		toDoRepository.deleteById(id);
		return true;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/savetodo")
	public ResponseEntity<ToDo> saveToDo(@RequestBody ToDo toDo) {
		toDo = toDoRepository.save(toDo);
		return ResponseEntity.ok(toDo);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updatetodo")
	public ResponseEntity<ToDo> updateToDo(@RequestBody ToDo toDo) {
		toDoRepository.save(toDo);
		return ResponseEntity.ok(toDo);
	}
	
}
