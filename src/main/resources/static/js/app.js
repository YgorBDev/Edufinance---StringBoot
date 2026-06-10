const statusCard = document.getElementById('statusCard');
const resultTable = document.getElementById('resultTable').querySelector('tbody');

function setStatus(message) {
    statusCard.textContent = message;
}

function clearResults() {
    resultTable.innerHTML = '';
}

function renderResults(data) {
    clearResults();

    if (!data || data.length === 0) {
        setStatus('Nenhum resultado encontrado para a consulta.');
        return;
    }

    setStatus(`Exibindo ${data.length} registro(s).`);

    data.forEach(item => {
        const row = document.createElement('tr');
        Object.entries(item).forEach(([key, value]) => {
            const keyCell = document.createElement('td');
            keyCell.textContent = key;
            const valueCell = document.createElement('td');
            valueCell.textContent = value === null || value === undefined ? '-' : value;
            row.appendChild(keyCell);
            row.appendChild(valueCell);
        });
        resultTable.appendChild(row);
    });
}

async function loadData(endpoint, message) {
    setStatus('Carregando...');
    try {
        const response = await fetch(endpoint);
        const data = await response.json();
        renderResults(Array.isArray(data) ? data : [data]);
    } catch (error) {
        setStatus(`Erro ao carregar dados: ${error.message}`);
        clearResults();
    }
}

const actionMap = {
    loadUsuarios: '/api/usuarios',
    loadCursos: '/api/cursos',
    loadAulas: '/api/aulas',
    loadInvestimentos: '/api/investimentos',
    loadSimulacoes: '/api/simulacoes',
    loadQuizzes: '/api/quizzes',
};

document.querySelectorAll('[data-action]').forEach(button => {
    button.addEventListener('click', () => {
        const endpoint = actionMap[button.dataset.action];
        if (endpoint) loadData(endpoint);
    });
});

document.getElementById('btnEmail').addEventListener('click', () => {
    const email = document.getElementById('emailInput').value.trim();
    if (!email) return setStatus('Informe um email para pesquisa.');
    loadData(`/api/usuarios/email?email=${encodeURIComponent(email)}`);
});

document.getElementById('btnCursoCategoria').addEventListener('click', () => {
    const categoria = document.getElementById('cursoCategoria').value.trim();
    if (!categoria) return setStatus('Informe a categoria do curso.');
    loadData(`/api/cursos/categoria?categoria=${encodeURIComponent(categoria)}`);
});

document.getElementById('btnAulaTipo').addEventListener('click', () => {
    const tipo = document.getElementById('aulaTipo').value.trim();
    if (!tipo) return setStatus('Informe o tipo de conteúdo da aula.');
    loadData(`/api/aulas/tipo-conteudo?tipoConteudo=${encodeURIComponent(tipo)}`);
});

setStatus('Pronto para carregar dados.');
