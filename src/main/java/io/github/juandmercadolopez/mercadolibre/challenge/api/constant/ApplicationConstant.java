package io.github.juandmercadolopez.mercadolibre.challenge.api.constant;

import org.springframework.beans.factory.annotation.Value;

public class ApplicationConstant {

  @Value("app.exception.ioexception.message")
  public static String ERROR_DURING_PROCESS;
}
