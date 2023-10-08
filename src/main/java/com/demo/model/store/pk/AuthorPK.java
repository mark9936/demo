package com.demo.model.store.pk;

import java.io.Serializable;
import lombok.Data;

@Data
public class AuthorPK implements Serializable {

    private String pNo;
    private String name;

}
