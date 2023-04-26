package com.productapp.product.exceptions;

import com.productapp.product.controller.params.ExportProduct;

import lombok.Getter;

public class ProductExportException  extends RuntimeException{

    @Getter
    private ExportProduct exportProduct;

    public ProductExportException(ExportProduct exportProduct) {
        this.exportProduct = exportProduct;
    }

    public ProductExportException(String message, final ExportProduct exportProduct) {
        super(message);
        this.exportProduct  = exportProduct;
    }

    public ProductExportException(Throwable cause, final ExportProduct exportProduct) {
        super(cause);
        this.exportProduct  = exportProduct;
    }

    public ProductExportException(String message, Throwable cause, final ExportProduct exportProduct) {
        super(message, cause);
        this.exportProduct  = exportProduct;
    }

    public ProductExportException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace, final ExportProduct exportProduct) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exportProduct  = exportProduct;
    }
}
