package br.com.solertech.goku.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.solertech.goku.application.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByZipcode(String zipcode);
}
