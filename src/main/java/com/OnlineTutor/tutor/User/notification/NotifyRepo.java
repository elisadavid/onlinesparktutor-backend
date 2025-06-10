package com.OnlineTutor.tutor.User.notification;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotifyRepo extends JpaRepository<NotifyModel,Long> {

    List<NotifyModel> findByUserId(Long userId);
}
