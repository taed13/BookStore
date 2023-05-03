$(document).ready(function () {
    $('#myCarousel').on('slid.bs.carousel', function () {
        var currentSlide = $('.carousel-item.active');
        var title = currentSlide.find('h5').text();
        var content = currentSlide.find('p').text();
        $('.position-relative h-100').html('<h3>' + title + '</h3><p>' + content + '</p>');
    });
});
