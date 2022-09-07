package com.general.carparking.pay;

import java.util.List;

public interface IPayService {

    Pay save(Pay pay);
    Pay update(Pay pay);
    void delete(Long id);
    Pay getById (Long id);
    List<Pay> getAll ();

}

