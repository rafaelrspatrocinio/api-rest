package com.br.apirest.servises;

import com.br.apirest.domain.User;
import com.br.apirest.dto.UserDTO;
import com.br.apirest.exception.ObjetcNotFoundException;
import com.br.apirest.repository.UserRepository;
import com.br.apirest.resource.exception.ResourceExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjetcNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repository.insert(obj);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public void delete(String id){
       findById(id);
       repository.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }
}
