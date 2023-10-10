package com.demo.model.store.pk;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BrowsePK implements Serializable {

    private String mId;

    private String pNo;

    private LocalDateTime browseTime;
}
