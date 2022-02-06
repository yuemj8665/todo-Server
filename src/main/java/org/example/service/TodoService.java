package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    // 1. todo리스트 목록에 아이템 추가
    public TodoEntity add(TodoRequest request) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.isCompleted());
        return this.repository.save(todoEntity);
    }
    // 2. todo리스트 목록 중 특정 아이템을 조회
    public TodoEntity searchById(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    // 3. todo리스트 전체 목록을 조회
    public List<TodoEntity> searchAll() {
        return this.repository.findAll();
    }
    // 4. todo리스트 목록 중 특정 아이템을 수정
    public TodoEntity updateById(Long id, TodoRequest request) {
        TodoEntity entity = this.searchById(id);
        if (request.getTitle() != null) {
            entity.setTitle(request.getTitle());
        }
        if (request.getOrder() != null) {
            entity.setOrder(request.getOrder());
        }
//        if (request.isCompleted() != null) {
//
//        }
        return this.repository.save(entity);
    }
    // 5. todo리스트 목록 중 특정 아이템을 삭제
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
    // 6. todo리스트 전체 목록 삭제
    public void deleteAll() {
        this.repository.deleteAll();
    }
}
