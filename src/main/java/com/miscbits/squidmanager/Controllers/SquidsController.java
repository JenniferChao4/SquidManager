package com.miscbits.squidmanager.Controllers;

import com.miscbits.squidmanager.Models.Squid;
import com.miscbits.squidmanager.Repositories.SquidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class SquidsController {

    @Autowired
    private SquidRepository squidRepository;

    @GetMapping(path = "/squids/edible")
    public ResponseEntity<Iterable<Squid>> edibleSquids() {
        Iterable<Squid> squids = squidRepository.findAll();

        Iterable<Squid> squiderator = StreamSupport.stream(squids.spliterator(), false)
                .filter(squid -> squid.isEdible())
                .collect(Collectors.toList());

        return new ResponseEntity<>(squiderator, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "squids/{id}")
    public ResponseEntity<Integer> squidBirthday(@PathVariable Long id) {
        Squid squid = squidRepository.findById(id).get();

        squid.celebrateBirthday();

        squidRepository.save(squid);

        Integer squidAge = squid.getAge();

        return new ResponseEntity<>(squidAge, HttpStatus.ACCEPTED);
    }
}
