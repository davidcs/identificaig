package br.com.identificaig.Idetificaig.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.identificaig.Idetificaig.models.Pin;

@Repository
public interface PinRepository extends JpaRepository<Pin, UUID> {
}
