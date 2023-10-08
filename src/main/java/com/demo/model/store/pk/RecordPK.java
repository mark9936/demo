package com.demo.model.store.pk;

import java.io.Serializable;
import lombok.Data;

@Data
public class RecordPK implements Serializable {

    private String tNo;

    private String pNo;
}
