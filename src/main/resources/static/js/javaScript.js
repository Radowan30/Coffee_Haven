function showAIRecommender() {
    new bootstrap.Modal(document.getElementById('aiRecommenderModal')).show();
}

function getAIRecommendations() {
    const flavorPreference = document.getElementById('flavorPreference').value;
    const roastLevel = document.getElementById('roastLevel').value;
    const brewMethod = document.getElementById('brewMethod').value;

    // In a real application, this would make an API call to an AI service
    // For now, we'll just randomly select 2 products as recommendations
    const recommendations = products
        .sort(() => 0.5 - Math.random())
        .slice(0, 2);

    document.getElementById('aiRecommendationsBody').innerHTML = `
                <p>Based on your preferences:</p>
                <ul>
                    <li>Flavor: ${flavorPreference}</li>
                    <li>Roast: ${roastLevel}</li>
                    <li>Brew Method: ${brewMethod}</li>
                </ul>
                <p>We recommend:</p>
                <div class="row">
                    ${recommendations.map(product => `
                        <div class="col-md-6 mb-3">
                            <div class="card">
                                <img src="${product.imageUrl}" class="card-img-top" alt="${product.name}">
                                <div class="card-body">
                                    <h5 class="card-title">${product.name}</h5>
                                    <p class="card-text">${product.description}</p>
                                    <button class="btn btn-primary" onclick="showProductDetails(${product.id})">View Details</button>
                                </div>
                            </div>
                        </div>
                    `).join('')}
                </div>
            `;

    new bootstrap.Modal(document.getElementById('aiRecommendationsModal')).show();
}
