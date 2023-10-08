package com.demo.model.store.pk;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CartPK implements Serializable {

    private String mId;

    private LocalDateTime cartTime;
}
