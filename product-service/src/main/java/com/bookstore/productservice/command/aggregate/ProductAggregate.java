package com.bookstore.productservice.command.aggregate;

import com.bookstore.commonservice.command.RollBackStatusProductCommand;
import com.bookstore.commonservice.command.UpdateStatusProductCommand;
import com.bookstore.commonservice.event.ProductRollBackStatusEvent;
import com.bookstore.commonservice.event.ProductUpdateStatusEvent;
import com.bookstore.productservice.command.command.CreateProductCommand;
import com.bookstore.productservice.command.command.DeleteProductCommand;
import com.bookstore.productservice.command.command.UpdateProductCommand;
import com.bookstore.productservice.command.events.ProductCreateEvent;
import com.bookstore.productservice.command.events.ProductDeleteEvent;
import com.bookstore.productservice.command.events.ProductUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.Date;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    private String slug;

    private Double price;

    private Double priceEntry;

    private String publisherId;

    private String authorId;

    private String productTypeId;

    private Double sale;

    private LocalDate expirationDate;

    private String avatar;

    private int view;

    private int hot;

    private int expiration;

    private int active;

    private String description;

    private String content;

    private int reviewTotal;

    private int reviewStar;

    private int ageReview;

    private int number;

    private int importGoods;

    private int numberImport;

    private String resistant;

    private String energy;

    private String countryCode;

    private int soldQuantity;

    private LocalDate publishedDate;

    private String condition;

    private String binding;
    private LocalDate createdAt;

    private LocalDate updatedAt;

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        ProductCreateEvent event = new ProductCreateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductCreateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.slug = event.getSlug();
        this.price = event.getPrice();
        this.priceEntry = event.getPriceEntry();
        this.publisherId = event.getPublisherId();
        this.authorId = event.getAuthorId();
        this.productTypeId = event.getProductTypeId();
        this.sale = event.getSale();
        this.expirationDate = event.getExpirationDate();
        this.avatar = event.getAvatar();
        this.view = event.getView();
        this.hot = event.getHot();
        this.expiration = event.getExpiration();
        this.active = event.getActive();
        this.description = event.getDescription();
        this.content = event.getContent();
        this.reviewStar = event.getReviewStar();
        this.reviewTotal = event.getReviewTotal();
        this.ageReview = event.getAgeReview();
        this.number = event.getNumber();
        this.importGoods = event.getImportGoods();
        this.numberImport = event.getNumberImport();
        this.resistant = event.getResistant();
        this.energy = event.getEnergy();
        this.countryCode = event.getCountryCode();
        this.soldQuantity = event.getSoldQuantity();
        this.publishedDate = event.getPublishedDate();
        this.condition = event.getCondition();
        this.binding = event.getBinding();
        this.createdAt = event.getCreatedAt();
        this.updatedAt = event.getUpdatedAt();
    }

    @CommandHandler
    public void handler(UpdateProductCommand command) {
        ProductUpdateEvent event = new ProductUpdateEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductUpdateEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.slug = event.getSlug();
        this.price = event.getPrice();
        this.priceEntry = event.getPriceEntry();
        this.publisherId = event.getPublisherId();
        this.authorId = event.getAuthorId();
        this.productTypeId = event.getProductTypeId();
        this.sale = event.getSale();
        this.expirationDate = event.getExpirationDate();
        this.avatar = event.getAvatar();
        this.view = event.getView();
        this.hot = event.getHot();
        this.expiration = event.getExpiration();
        this.active = event.getActive();
        this.description = event.getDescription();
        this.content = event.getContent();
        this.reviewStar = event.getReviewStar();
        this.reviewTotal = event.getReviewTotal();
        this.ageReview = event.getAgeReview();
        this.number = event.getNumber();
        this.importGoods = event.getImportGoods();
        this.numberImport = event.getNumberImport();
        this.resistant = event.getResistant();
        this.energy = event.getEnergy();
        this.countryCode = event.getCountryCode();
        this.soldQuantity = event.getSoldQuantity();
        this.publishedDate = event.getPublishedDate();
        this.condition = event.getCondition();
        this.binding = event.getBinding();
        this.createdAt = event.getCreatedAt();
        this.updatedAt = event.getUpdatedAt();
    }

    @CommandHandler
    public void handler(DeleteProductCommand command) {
        ProductDeleteEvent event = new ProductDeleteEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductDeleteEvent event) {
        this.id = event.getId();
    }


    @CommandHandler
    public void handle(UpdateStatusProductCommand command) {
        ProductUpdateStatusEvent event = new ProductUpdateStatusEvent();
        event.setId(command.getId());
        event.setSoldQuantity(command.getSoldQuantity());
        event.setUserId(command.getUserId());
        event.setCartId(command.getCartId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductUpdateStatusEvent event) {
        this.id = event.getId();
        this.soldQuantity = event.getSoldQuantity();
    }

    @CommandHandler
    public void handle(RollBackStatusProductCommand command) {
        ProductRollBackStatusEvent event = new ProductRollBackStatusEvent();
        event.setId(command.getId());
        event.setSoldQuantity(command.getSoldQuantity());
        event.setUserId(command.getUserId());
        event.setCartId(command.getCartId());
        AggregateLifecycle.apply(event);
    }
    @EventSourcingHandler
    public void on(ProductRollBackStatusEvent event) {
        this.id = event.getId();
        this.soldQuantity = event.getSoldQuantity();
    }
}
